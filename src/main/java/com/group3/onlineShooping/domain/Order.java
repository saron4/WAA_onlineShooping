package com.group3.onlineShooping.domain;


import com.group3.onlineShooping.constants.Constants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "Orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //    @Transient
//    @OneToOne
//    private Buyer buyer;
    //@OneToOne
    //private Seller seller;
    @JoinColumn
    @OneToOne(cascade = CascadeType.MERGE)
    private CartItem cartItem;
    // @Transient
    // private Product product;
    //private Integer quantity;

    @DateTimeFormat(pattern = Constants.DATE_FORMATTER)
    private LocalDateTime orderDate;

    @DateTimeFormat(pattern = Constants.DATE_FORMATTER)
    private LocalDateTime lastUpdatedDate;

    @OneToOne//(cascade = CascadeType.MERGE)
    private Payment payment;

    @OneToOne//(cascade = CascadeType.MERGE)
    private CouponPayment couponPayment;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "orderHistory_id")
    private Order orderHistory;

    @OneToMany(mappedBy = "orderHistory")
    private Set<Order> subordinates = new HashSet<Order>();


//    @OneToOne
//    private ShippingAddress shippingAddress;
//    private ShippingStatus shippingStatus;
//

    private OrderStatus orderStatus = OrderStatus.ORDERED;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public CouponPayment getCouponPayment() {
        return couponPayment;
    }

    public void setCouponPayment(CouponPayment couponPayment) {
        this.couponPayment = couponPayment;
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

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}