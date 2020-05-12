package com.group3.onlineShooping.domain;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Payment {

    @Id
    @GeneratedValue
    private Long Id;

    @NotBlank
    private String cardType = "VISA";
    @NotBlank
    private String cardName;
    @NotBlank
    @Size(min = 10, max = 20,message = "{size.cardNumber}")
    private String cardNumber;
    @NotNull
    private Double totalPrice;

    @NotNull
    private Integer expYear;

    @NotBlank
    private String expMonth;

    @NotNull
    @Range(min = 3, max = 4,message = "{size.CVV}")
    private Integer CVV;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private ShippingAddress shippingAddress;

    @JoinColumn
    @OneToOne(cascade = CascadeType.MERGE)
    private CartItem cartItem;

    public Payment() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getExpYear() {
        return expYear;
    }

    public void setExpYear(Integer expYear) {
        this.expYear = expYear;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public Integer getCVV() {
        return CVV;
    }

    public void setCVV(Integer CVV) {
        this.CVV = CVV;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "Id=" + Id +
                ", cardType='" + cardType + '\'' +
                ", cardName='" + cardName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expYear=" + expYear +
                ", expMonth=" + expMonth +
                ", CVV=" + CVV +
                ", shippingAddress=" + shippingAddress +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Payment))
            return false;
        Payment payment = (Payment) o;
        return Objects.equals(getCardType(), payment.getCardType())
                && Objects.equals(getCardName(), payment.getCardName())
                && Objects.equals(getCardNumber(), payment.getCardNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardType(), getCardName(), getCardNumber());
    }
}
