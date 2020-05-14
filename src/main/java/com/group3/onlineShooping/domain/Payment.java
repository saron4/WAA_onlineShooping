package com.group3.onlineShooping.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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



@NoArgsConstructor
@Setter
@Getter
@ToString

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
    @Range(min = 100, max = 9999, message = "{size.CVV}")
    private Integer CVV;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private ShippingAddress shippingAddress;

    @JoinColumn
    @OneToOne(cascade = CascadeType.MERGE)
    private CartItem cartItem;
}
