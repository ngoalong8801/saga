package com.pm.order.service;

//import com.pm.common.dto.response.Response;
//import com.pm.common.utils.Utils;
import com.pm.common.constant.EventType;
import com.pm.common.constant.OrderStatus;
import com.pm.common.converters.Converter;
import com.pm.common.dto.event.Event;
import com.pm.common.dto.event.OrderRecord;
import com.pm.common.dto.request.OrderRequest;
import com.pm.common.dto.response.Order;
import com.pm.common.dto.response.Response;
import com.pm.common.event.EventService;
import com.pm.common.model.OrderR;
import com.pm.common.utils.Utils;
import com.pm.order.converter.MapProductQuantityConverter;
import com.pm.order.converter.OrderEntity2OrderRecordConverter;
import com.pm.order.converter.OrderEntityConverter;
import com.pm.order.converter.OrderRequest2OrderRecordConverter;
import com.pm.order.entity.OrderEntity;
import com.pm.order.populator.OrderDetailPopulator;
import com.pm.order.repository.OrderRepository;
import com.pm.order.repository.ProductRepository;
import com.pm.common.repository.OrderRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderEntityConverter orderEntityConverter;

    @Autowired
    MapProductQuantityConverter mapProductQuantityConverter;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    Utils<Order> orderUtils;

    @Autowired
    OrderDetailPopulator orderDetailPopulator;

    @Autowired
    EventService eventService;

    @Autowired
    OrderEntity2OrderRecordConverter orderEntity2OrderRecordConverter;
    @Autowired
    OrderRequest2OrderRecordConverter orderRequest2OrderRecordConverter;

    @Autowired
    OrderRRepository orderRRepository;

    @Autowired
    Converter<OrderEntity, OrderR> orderEntity2OrderRConverter;

    public Response<Order> createOrder(OrderRequest request)  {
        OrderEntity entity = initOrder(request);
        Order orderData = orderEntityConverter.convert(entity);
        createOrderForRead(entity);
        publishOrderCreatedEvent(request, entity);
        return orderUtils.generateSuccessResponse(orderData);
    }

    private void createOrderForRead(OrderEntity entity) {
        OrderR orderR = orderEntity2OrderRConverter.convert(entity);
        orderRRepository.save(orderR);
    }

    private void publishOrderCreatedEvent(OrderRequest request, OrderEntity entity) {
        OrderRecord record = orderEntity2OrderRecordConverter.convert(entity);
        record = orderRequest2OrderRecordConverter.convert(request, record);
        Event<OrderRecord> orderCreatedEvent = new Event.Builder<OrderRecord>()
                .record(record)
                .eventType(EventType.ORDER_CREATED_EVENT)
                .build();
        eventService.publishEvent(orderCreatedEvent);
    }

    private OrderEntity initOrder(OrderRequest request) {
        OrderEntity entity = new OrderEntity();
        entity.setUserEmail(request.getCustomerEmail());
        entity.setStatus(OrderStatus.PENDING);
        orderRepository.save(entity);
        return entity;
    }

//     public void processCreatingOrder(OrderRequest request, OrderEntity order) {
//        try {
//            productService.deductQuantityOfProduct(request);
//            List<OrderDetailEntity> orderDetailEntities = getOrderDetails(request);
//            populateOrderData(order, orderDetailEntities);
//
//        } catch (Exception e) {
//            order.setStatus(OrderStatus.FAILED);
//            throw e;
//        }
//        finally {
//            orderRepository.save(order);
//        }
//    }

//    public List<OrderDetailEntity> getOrderDetails(OrderRequest request) {
//        Map<Integer, ProductEntity> products = productService.findProductByIds(request).stream().collect(Collectors.toMap(ProductEntity::getId, product -> product));
//        Map<ProductEntity, Integer> productQuantities = request.getItems().stream().collect(Collectors.toMap(
//                entry -> products.get(entry.getId()),
//                ProductQRequest::getQuantity
//        ));
//        return mapProductQuantityConverter.convertAll(productQuantities.entrySet());
//    }
//
//    private void populateOrderData(OrderEntity order, List<OrderDetailEntity> orderDetailEntities) {
//        order.setUserEmail(DEFAULT_USER_EMAIL_FOR_TESTING);
//        order.setOrderDetails(orderDetailEntities);
//        Populators.populateAll(order, orderDetailEntities, orderDetailPopulator);
//        int total = orderDetailEntities.stream().reduce(0, (subtotal, entry) -> subtotal + entry.getCurPrice() * entry.getQuantity(), Integer::sum);
//        order.setTotalPrice(total);
//    }
}
