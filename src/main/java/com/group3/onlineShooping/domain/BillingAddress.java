package com.group3.onlineShooping.domain;

import javax.persistence.Embeddable;
@Embeddable
public class BillingAddress {
    private String billStreet;
    private String billCity ;
    private String billState ;
    private String billZip ;


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
}
