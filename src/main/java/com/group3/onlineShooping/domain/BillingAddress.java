package com.group3.onlineShooping.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Embeddable
public class BillingAddress {
    @NotBlank
    private String billFullName;
    @Email
    @NotBlank
    private String billEmail;
    @NotBlank
    private String billStreet;
    @NotBlank
    private String billCity;
    @NotBlank
    private String billState;
    @NotBlank
    private String billZip;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillingAddress that = (BillingAddress) o;
        return Objects.equals(billStreet, that.billStreet) &&
                Objects.equals(billCity, that.billCity) &&
                Objects.equals(billState, that.billState) &&
                Objects.equals(billZip, that.billZip);
    }

    public String getBillFullName() {
        return billFullName;
    }

    public void setBillFullName(String billFullName) {
        this.billFullName = billFullName;
    }

    public String getBillEmail() {
        return billEmail;
    }

    public void setBillEmail(String billEmail) {
        this.billEmail = billEmail;
    }

    @Override
    public int hashCode() {
        return Objects.hash(billStreet, billCity, billState, billZip);
    }

    public String getBillStreet() {
        return billStreet;
    }

    public void setBillStreet(String billStreet) {
        this.billStreet = billStreet;
    }

    public String getBillCity() {
        return billCity;
    }

    public void setBillCity(String billCity) {
        this.billCity = billCity;
    }

    public String getBillState() {
        return billState;
    }

    public void setBillState(String billState) {
        this.billState = billState;
    }

    public String getBillZip() {
        return billZip;
    }

    public void setBillZip(String billZip) {
        this.billZip = billZip;
    }

    @Override
    public String toString() {
        return "BillingAddress{" +
                "billFullName='" + billFullName + '\'' +
                ", billEmail='" + billEmail + '\'' +
                ", billStreet='" + billStreet + '\'' +
                ", billCity='" + billCity + '\'' +
                ", billState='" + billState + '\'' +
                ", billZip='" + billZip + '\'' +
                '}';
    }
}
