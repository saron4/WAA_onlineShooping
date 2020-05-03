package com.group3.onlineShooping.domain;

import javax.validation.constraints.NotBlank;

public class PhoneNumber {
    @NotBlank
    private String areaCode;
    @NotBlank
    private String number;

}
