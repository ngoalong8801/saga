package com.pm.order.controller;

import com.pm.common.dto.request.OrderRequest;
import com.pm.common.dto.response.Order;
import com.pm.common.dto.response.Response;
import com.pm.order.service.OrderService;
//import com.pm.common.dto.Account;
//import com.pm.common.dto.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;

@Controller
@RequestMapping(path = "/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("")
    public @ResponseBody Response<Order> createOrder(@RequestBody OrderRequest request) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return orderService.createOrder(request);
    }
}
