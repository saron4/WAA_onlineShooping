package com.group3.onlineShooping.domain;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity(name = "Orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Transient
    @OneToOne
    private Buyer buyer;
    //@OneToOne
    //private Seller seller;
    @Transient
    private CartItem cartItem;
    // @Transient
    // private Product product;
    //private Integer quantity;

    private LocalDate orderDate;
    @OneToOne//(cascade = CascadeType.MERGE)
    private Payment payment;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "orderHistory_id")
    private Order orderHistory;

    @OneToMany(mappedBy = "orderHistory")
    private Set<Order> subordinates = new HashSet<Order>();


//    @OneToOne
//    private ShippingAddress shippingAddress;
//    private ShippingStatus shippingStatus;
//

    private OrderStatus orderStatus;

    public Order() {
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus == null ? OrderStatus.InitOrderStatus() : orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Order getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(Order orderHistory) {
        this.orderHistory = orderHistory;
    }

    public Set<Order> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<Order> subordinates) {
        this.subordinates = subordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getBuyer().equals(order.getBuyer()) &&
                getCartItem().equals(order.getCartItem()) &&
                getOrderDate().equals(order.getOrderDate()) &&
                getPayment().equals(order.getPayment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBuyer(), getCartItem(), getOrderDate(), getPayment());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", cartItem=" + cartItem +
                ", orderDate=" + orderDate +
                ", payment=" + payment +
                '}';
    }
}