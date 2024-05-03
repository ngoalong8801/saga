package com.pm.inventory.service;

import com.pm.common.dto.Product;
import com.pm.common.dto.event.OrderRecord;
import com.pm.common.dto.event.ProductRecord;
import com.pm.common.dto.request.OrderRequest;
import com.pm.common.dto.response.Response;
import com.pm.common.utils.Utils;
import com.pm.inventory.constant.Constant;
import com.pm.inventory.converter.ProductDataConverter;
import com.pm.inventory.entity.ProductEntity;
import com.pm.inventory.exception.ProductNotFoundException;
import com.pm.inventory.exception.ProductExceedThresholdException;
import com.pm.inventory.repository.ProductRepository;
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
    public void deductQuantityOfProduct(OrderRecord record) {
        List<ProductRecord> productRecords = record.getItems();
        for (var productRecord : productRecords) {
            Integer productId = productRecord.getId();
            Integer quantityToDeduct = productRecord.getQuantity();

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

    public List<ProductEntity> findProductByIds(OrderRecord orderRecord) {
        Set<Integer> productIds = orderRecord.getItems().stream().map(ProductRecord::getId).collect(Collectors.toSet());
        List<ProductEntity> products = productRepository.findAllById(productIds);
        Set<Integer> foundIds = products.stream().map(ProductEntity::getId).collect(Collectors.toSet());
        productIds.forEach(id -> {
            if (!foundIds.contains(id))
                throw new ProductNotFoundException(String.valueOf(id));
        });
        return products;
    }
}
