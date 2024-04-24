package com.pm.order.service;

//import com.pm.common.dto.response.Response;
//import com.pm.common.utils.Utils;
import com.pm.common.constant.OrderStatus;
import com.pm.common.converters.Populators;
import com.pm.common.dto.event.Event;
import com.pm.common.dto.event.OrderCreatedEvent;
import com.pm.common.dto.event.OrderRecord;
import com.pm.common.dto.event.Record;
import com.pm.common.dto.request.OrderRequest;
import com.pm.common.dto.response.Order;
import com.pm.common.dto.response.Response;
import com.pm.common.event.EventService;
import com.pm.common.utils.EventUtils;
import com.pm.common.utils.Utils;
import com.pm.order.converter.MapProductQuantityConverter;
import com.pm.order.converter.OrderData2OrderRecordConverter;
import com.pm.order.converter.OrderDetailEntityConverter;
import com.pm.order.converter.OrderEntityConverter;
import com.pm.order.entity.OrderDetailEntity;
import com.pm.order.entity.OrderEntity;
import com.pm.order.entity.ProductEntity;
import com.pm.order.populator.OrderDetailPopulator;
import com.pm.order.repository.OrderRepository;
import com.pm.order.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

import static com.pm.order.constant.Constant.DEFAULT_USER_EMAIL_FOR_TESTING;


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
    ProductService productService;
    @Autowired
    OrderDetailPopulator orderDetailPopulator;

    @Autowired
    EventService eventService;

    @Autowired
    OrderData2OrderRecordConverter orderData2OrderRecordConverter;

    public Response<Order> createOrder(OrderRequest request) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        OrderEntity order = new OrderEntity();
        order.setStatus(OrderStatus.PENDING);
        processCreatingOrder(request, order);
        Order orderData = orderEntityConverter.convert(order);
        OrderRecord record = orderData2OrderRecordConverter.convert(orderData);
        EventUtils.publishEvent(record, OrderCreatedEvent.class, eventService);
        return orderUtils.generateSuccessResponse(orderData);
    }

     public void processCreatingOrder(OrderRequest request, OrderEntity order) {
        try {
            productService.deductQuantityOfProduct(request.getProductQuantities());
            List<OrderDetailEntity> orderDetailEntities = getOrderDetails(request);
            populateOrderData(order, orderDetailEntities);

        } catch (Exception e) {
            order.setStatus(OrderStatus.FAILED);
            throw e;
        }
        finally {
            orderRepository.save(order);
        }
    }

    public List<OrderDetailEntity> getOrderDetails(OrderRequest request) {
        Map<Integer, ProductEntity> products = productService.findProductByIds(request).stream().collect(Collectors.toMap(product -> product.getId(), product -> product));
        Map<ProductEntity, Integer> productQuantities = request.getProductQuantities().entrySet().stream().collect(Collectors.toMap(
                entry -> products.get(entry.getKey()),
                Map.Entry::getValue
        ));
        return mapProductQuantityConverter.convertAll(productQuantities.entrySet());
    }

    private void populateOrderData(OrderEntity order, List<OrderDetailEntity> orderDetailEntities) {
        order.setUserEmail(DEFAULT_USER_EMAIL_FOR_TESTING);
        order.setOrderDetails(orderDetailEntities);
        Populators.populateAll(order, orderDetailEntities, orderDetailPopulator);
        int total = orderDetailEntities.stream().reduce(0, (subtotal, entry) -> subtotal + entry.getCurPrice() * entry.getQuantity(), Integer::sum);
        order.setTotalPrice(total);
    }
}
