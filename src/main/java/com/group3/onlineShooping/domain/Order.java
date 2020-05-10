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

    @Transient
    @OneToOne
    private Buyer buyer;
    //@OneToOne
    //private Seller seller;
    @Transient
    @OneToOne
    private CartItem cartItem;
    // @Transient
    // private Product product;
    //private Integer quantity;

    private LocalDate orderDate;
    @OneToOne(cascade = CascadeType.ALL)
    private Payment payment;

//    @OneToOne
//    private ShippingAddress shippingAddress;
//    private ShippingStatus shippingStatus;
//

    private ShippingStatus shippingStatus;

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

    public ShippingStatus getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(ShippingStatus shippingStatus) {
        this.shippingStatus = shippingStatus;
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