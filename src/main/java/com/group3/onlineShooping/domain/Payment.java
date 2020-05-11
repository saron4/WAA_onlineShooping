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
    private String cardNumber;
    @NotNull
    private Double totalPrice;

    //@NotNull
    //@DateTimeFormat(pattern = "MM-yyyy")
    private String expiryDate;

    @Transient
    @NotNull
    @Range(min = 2020, max = 2030)
    private Integer expYear;

    @Transient
    @NotNull
    @Range(min = 1, max = 12)
    private Integer expMonth;

    @NotBlank
    @Size(min = 3, max = 4)
    @Pattern(regexp = "^[0-9]{3,4}$")
    private String CVV;

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

    public Integer getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(Integer expMonth) {
        this.expMonth = expMonth;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
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

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = getExpMonth() + "/" + getExpYear();
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
                ", expiryDate=" + expiryDate +
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
                && Objects.equals(getCardNumber(), payment.getCardNumber())
                && Objects.equals(getExpiryDate(), payment.getExpiryDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardType(), getCardName(), getCardNumber(), getExpiryDate());
    }
}
