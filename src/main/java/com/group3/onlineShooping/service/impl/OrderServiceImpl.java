package com.group3.onlineShooping.service.impl;

import com.group3.onlineShooping.domain.Notification;
import com.group3.onlineShooping.domain.Order;
import com.group3.onlineShooping.repository.OrderRepository;
import com.group3.onlineShooping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private NotificationServiceImpl notificationService;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Order> getAll() {
        Iterable<Order> orderIterable = orderRepository.findAll();
        List<Order> orders = new ArrayList<>();
        orderIterable.forEach(orders::add);
        return orders;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Order getOrder(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        if (!order.isPresent()) {
            // a cusmtom excepttion has to be thrown
            try {
                throw new Exception("order not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return order.get();
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = getOrder(id);
        orderRepository.delete(order);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Order editOrder(Order order) {
        if (order.getId() == null) {
            order = orderRepository.save(order);
            return order;
        } else {
            Optional<Order> existingEntity = orderRepository.findById(order.getId());
            if (existingEntity.isPresent()) {
                Order newEntity = existingEntity.get();
                newEntity.setShippingStatus(order.getShippingStatus());

                newEntity = orderRepository.save(newEntity);

                Notification notification = new Notification();
                notification.setOrder(order);
                notification.setMessage("Order status updated!");
                notification.setShippingStatus(order.getShippingStatus());
                notificationService.addNotification(notification);

                return newEntity;
            } else {
                order = orderRepository.save(order);
                return order;
            }
        }
    }

}
