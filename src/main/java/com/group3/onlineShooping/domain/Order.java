package com.group3.onlineShooping.domain;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Entity(name = "Orders")
public class Order {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Buyer buyer;
//    @OneToOne
//    private Seller seller;
    @OneToOne
    private CartItem cartItem;
    // @Transient
    // private Product product;
    private Integer quantity;
    private LocalDate orderDate;
    @OneToOne
    private Payment payment;

    @OneToOne
    private ShippingAddress shippingAddress;
    private ShippingStatus shippingStatus;

}