package com.pm.order.service;

import com.pm.common.dto.Product;
import com.pm.common.dto.response.Response;
import com.pm.common.utils.Utils;
import com.pm.order.converter.ProductDataConverter;
import com.pm.order.entity.ProductEntity;
import com.pm.order.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.util.List;

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
}
