package com.pm.order.controller;

import com.pm.common.dto.Product;
import com.pm.common.dto.response.Response;
import com.pm.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    ProductService productService;

//    public Response<Product> addProducts(@RequestBody List<Product> products) {
//
//    }
//}

