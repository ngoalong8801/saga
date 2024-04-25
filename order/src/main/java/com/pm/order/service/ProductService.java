package com.pm.order.service;

import com.pm.common.dto.Product;
import com.pm.common.dto.request.OrderRequest;
import com.pm.common.dto.request.ProductQRequest;
import com.pm.common.dto.response.Response;
import com.pm.common.utils.Utils;
import com.pm.order.constant.Constant;
import com.pm.order.converter.ProductDataConverter;
import com.pm.order.entity.ProductEntity;
import com.pm.order.exception.ProductNotFoundException;
import com.pm.order.exception.ProductExceedThresholdException;
import com.pm.order.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductDataConverter productDataConverter;
    @Autowired
    Utils<Product> productUtils;
    public Response<Product> addProducts(List<Product> products) {
        List<ProductEntity> entities = productDataConverter.convertAll(products);
        productRepository.saveAll(entities);
        return productUtils.generateSuccessResponse(products);
    }

    @Transactional
    public void deductQuantityOfProduct(OrderRequest request) {
        for (var productQ : request.getItems()) {
            Integer productId = productQ.getId();
            int quantityToDeduct = productQ.getQuantity();

            ProductEntity product = productRepository.findById(productId).orElseThrow(
                    () -> new ProductNotFoundException(String.valueOf(productId))
            );

            if (product.getThreshold() < quantityToDeduct) {
                throw new ProductExceedThresholdException(Constant.PRODUCT_THRESHOLD_EXCEEDED +  " " + product.getName());
            }

            product.setThreshold(product.getThreshold() - quantityToDeduct);
            productRepository.save(product);
        }
    }

    public List<ProductEntity> findProductByIds(OrderRequest request) {
        Set<Integer> productIds = request.getItems().stream().map(ProductQRequest::getId).collect(Collectors.toSet());
        List<ProductEntity> products = productRepository.findAllById(productIds);
        Set<Integer> foundIds = products.stream().map(ProductEntity::getId).collect(Collectors.toSet());
        productIds.forEach(id -> {
            if (!foundIds.contains(id))
                throw new ProductNotFoundException(String.valueOf(id));
        });
        return products;
    }
}
