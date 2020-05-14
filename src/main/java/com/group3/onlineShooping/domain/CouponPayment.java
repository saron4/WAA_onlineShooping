package com.group3.onlineShooping.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class CouponPayment {

    @javax.persistence.Id
    @GeneratedValue
    private Long Id;

    @NotNull
    private Double totalPrice;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private ShippingAddress shippingAddress;

    @JoinColumn
    @OneToOne(cascade = CascadeType.MERGE)
    private CartItem cartItem;

    private Boolean rememberMe;
}