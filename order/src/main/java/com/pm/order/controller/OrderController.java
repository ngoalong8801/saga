package com.pm.order.controller;

import com.pm.order.service.OrderService;
//import com.pm.common.dto.Account;
//import com.pm.common.dto.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    OrderService orderService;
}