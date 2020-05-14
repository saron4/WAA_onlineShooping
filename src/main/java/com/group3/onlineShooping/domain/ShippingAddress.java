package com.group3.onlineShooping.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class ShippingAddress {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    private String fullName;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank
    private String state;
    @NotBlank
    private String zip;
    @OneToOne
    private Buyer buyer;
}
