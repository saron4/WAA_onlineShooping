package com.group3.onlineShooping.serviceimpl;

import com.group3.onlineShooping.domain.Notification;
import com.group3.onlineShooping.domain.Order;
import com.group3.onlineShooping.domain.OrderStatus;
import com.group3.onlineShooping.repository.OrderRepository;
import com.group3.onlineShooping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("OrderServiceImpl")
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private NotificationServiceImpl notificationService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    OrderHistoryServiceImpl orderHistoryService;

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
        return orders.stream().filter(order -> order.getOrderHistory() == null).collect(Collectors.toList());
    }

    @Override
    public List<Order> getAllBySeller(String username) {
        List<Order> orders = orderRepository.getAllBySeller(username)
                .stream().filter(o -> o.getOrderHistory() == null)
                .collect(Collectors.toList());
        return orders;
    }

    @Override
    public List<Order> getAllByBuyer(String username) {
        List<Order> orders = orderRepository.getAllByBuyer(username)
                .stream().filter(o -> o.getOrderHistory() == null)
                .collect(Collectors.toList());
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
        order.setOrderStatus(OrderStatus.CANCELD);
        editOrder(order);
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
                //  Status update
                Order newEntity = existingEntity.get();
                newEntity.setOrderStatus(order.getOrderStatus());
                newEntity = orderRepository.save(newEntity);

                //  Notification
                Notification notification = new Notification();
                notification.setOrder(order);
                notification.setMessage("Order status updated!");
                notification.setOrderStatus(order.getOrderStatus());
                notificationService.addNotification(notification);

                // Record History
                Order existingOrderEntity = existingEntity.get();
                Order orderHistory = new Order();
                orderHistory.setLastUpdatedDate(LocalDateTime.now());
                orderHistory.setOrderDate(existingOrderEntity.getOrderDate());
                orderHistory.setOrderStatus(existingOrderEntity.getOrderStatus());
                orderHistory.setCartItem(existingOrderEntity.getCartItem());
                orderHistory.setOrderHistory(existingOrderEntity.getOrderHistory());
                orderHistory.setPayment(existingOrderEntity.getPayment());
                orderHistory.getSubordinates().add(existingOrderEntity);
                orderHistory.setOrderHistory(existingOrderEntity);
                orderHistoryService.addOrder(orderHistory);
                return newEntity;
            } else {
                order = orderRepository.save(order);
                return order;
            }
        }
    }

}