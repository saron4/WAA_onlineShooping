package com.group3.onlineShooping.domain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
@Getter
@Setter
@Entity
public class Seller {
    @Id
    @GeneratedValue
    private Long serllerId;


    @NotBlank
    private String fullName;

    @Valid
    @Embedded
    private PhoneNumber phoneNumber;

    @NotBlank
    @Email
    private String email;


   // @OneToMany
  //  private List<Product> products;


/*
    @ManyToMany(mappedBy = "seller")
    private List<Buyer> buyer;*/


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_Id")
    @Valid
    private User user;


    public Seller() {
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getSerllerId() {
        return serllerId;
    }

    public void setSerllerId(Long serllerId) {
        this.serllerId = serllerId;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Seller{" +

                ", fullName='" + fullName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +

                '}';
    }

}
