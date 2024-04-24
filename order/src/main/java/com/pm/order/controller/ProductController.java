package com.pm.order.controller;

import com.pm.common.dto.Product;
import com.pm.common.dto.response.Response;
import com.pm.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/product")
public class ProductController {
    ProductService productService;
    @Autowired
    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/addBulk")
    public @ResponseBody Response<Product> addProducts(@RequestBody List<Product> products) {
        return productService.addProducts(products);
    }
}

