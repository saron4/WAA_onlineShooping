package com.group3.onlineShooping.service;

import com.group3.onlineShooping.domain.Order;

import java.util.List;


public interface OrderService {
    public void addOrder(Order order);

    public List<Order> getAll();

    public Order getOrder(Long id);

    public boolean deleteOrder(Long id);

    public Order editOrder(Order order);
}
