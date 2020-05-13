package com.group3.onlineShooping.domain;

 

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Objects;

 

public class Order {
    @Id
    @GeneratedValue
    private Long id;
   //   Orders: ID, Client, Product, Quantity, Price, Date, OrderShipped
    private Buyer buyer;
    private Seller seller;
    private Product product;
    private Integer quantity;
    private LocalDate orderDate;

    private Payment payment;
    private BillingAddress billingAddress;
    private ShippingAddress shippingAddress;
    private ShippingStatus shippingStatus; 

    public Order() {
    }

    public Long getId() {
        return id;
    }

 

    public void setId(Long id) {
        this.id = id;
    }

 

    public Buyer getBuyer() {
        return buyer;
    }

 

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

 

    public Seller getSeller() {
        return seller;
    }

 

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

 

    public Product getProduct() {
        return product;
    }

 

    public void setProduct(Product product) {
        this.product = product;
    }

 

    public Integer getQuantity() {
        return quantity;
    }

 

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

 

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

 

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

 

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

 

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

 

    public ShippingStatus getShippingStatus() {
        return shippingStatus;
    }

 

    public void setShippingStatus(ShippingStatus shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

 

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", product=" + product +
                ", quantity=" + quantity +
                ", orderDate=" + orderDate +
                ", payment=" + payment +
                ", billingAddress=" + billingAddress +
                ", shippingAddress=" + shippingAddress +
                ", shippingStatus=" + shippingStatus +
                '}';
    }

 

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getBuyer().equals(order.getBuyer()) &&
                getSeller().equals(order.getSeller()) &&
                getProduct().equals(order.getProduct()) &&
                getQuantity().equals(order.getQuantity()) &&
                getOrderDate().equals(order.getOrderDate()) &&
                getPayment().equals(order.getPayment()) &&
                getBillingAddress().equals(order.getBillingAddress()) &&
                getShippingAddress().equals(order.getShippingAddress()) &&
                getShippingStatus() == order.getShippingStatus();
    }

 

    @Override
    public int hashCode() {
        return Objects.hash(getBuyer(), getSeller(), getProduct(), getQuantity(), getOrderDate(), getPayment(), getBillingAddress(), getShippingAddress(), getShippingStatus());
    }
}