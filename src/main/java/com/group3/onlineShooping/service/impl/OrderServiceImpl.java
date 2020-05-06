package com.group3.onlineShooping.service.impl;

import com.group3.onlineShooping.domain.Order;
import com.group3.onlineShooping.repository.OrderRepository;
import com.group3.onlineShooping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Order> getAll() {
        Iterable<Order> orderIterable = orderRepository.findAll();
        List<Order> orders = new ArrayList<>();
        while (orderIterable.iterator().hasNext()) {
            orders.add(orderIterable.iterator().next());
        }
        return orders;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Order getOrder(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (!order.isPresent()) {
            // a cusmtom excepttion has to be thrown
            System.out.println("Order not found");
            //throw new Exception("Order not found");
        }
        return order.get();
    }

    @Override
    public boolean deleteOrder(Long id) {
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Order editOrder(Order order) {
        Order updatedOrder = orderRepository.save(order);
        return updatedOrder;
    }

}
