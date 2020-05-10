package com.group3.onlineShooping.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Notification {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String message;

    @NotNull
    private OrderStatus orderStatus;

    @ManyToOne
    private Order order;

    private Boolean seen;

//    @OneToOne
//    private Buyer buyer;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Boolean getSeen() {
        return seen == null ? false : seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }
}
