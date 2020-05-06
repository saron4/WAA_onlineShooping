package com.group3.onlineShooping.controller;

import com.group3.onlineShooping.domain.Order;
import com.group3.onlineShooping.domain.Payment;
import com.group3.onlineShooping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String payment() {
        return "order/order";
    }

    @PostMapping
    public String payment(@Valid Order order, BindingResult result) {
        if (result.hasErrors()) {

        }
        return "order/order";
    }
}
