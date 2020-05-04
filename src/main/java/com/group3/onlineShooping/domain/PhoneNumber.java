package com.group3.onlineShooping.domain;

import javax.persistence.Embeddable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Embeddable
public class PhoneNumber {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String areaCode;
    @NotBlank
    private String number;
}
