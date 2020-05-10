package com.group3.onlineShooping.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class PhoneNumber {
    @NotBlank
    private String areaCode;
    @NotBlank
    private String number;
    @NotBlank
    private String prefix;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

}
