package com.group3.onlineShooping.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Entity(name = "Orders")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Buyer buyer;
    //@OneToOne
    //private Seller seller;
    @OneToOne
    private CartItem cartItem;
    // @Transient
    // private Product product;
    private Integer quantity;
    private LocalDate orderDate = LocalDate.now();
    @OneToOne
    private Payment payment;

    @OneToOne
    private ShippingAddress shippingAddress;
    private ShippingStatus shippingStatus;

}