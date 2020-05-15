package com.group3.onlineShooping.service;

import com.group3.onlineShooping.domain.Order;

import java.util.List;


public interface OrderService {
    Order addOrder(Order order);

    List<Order> getAll();

    List<Order> getAllBySeller(String username);

    List<Order> getAllByBuyer(String username);

    Order getOrder(Long id);

    void deleteOrder(Long id);

    Order editOrder(Order order);
}
