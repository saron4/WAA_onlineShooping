package com.group3.onlineShooping.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Seller implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String fullName;

    @Valid
    @Embedded
    private PhoneNumber phoneNumber;

    @NotBlank
    @Email
    private String email;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;


    //@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @ManyToMany
    @JoinTable// (name="Follower")
    //@joinColumns={@JoinColumn(name="serllerId")} ) 

    private List<Buyer> buyer;

    public Seller() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seller)) return false;
        Seller seller = (Seller) o;
        return Objects.equals(getId(), seller.getId()) &&
                getFullName().equals(seller.getFullName()) &&
                getPhoneNumber().equals(seller.getPhoneNumber()) &&
                getEmail().equals(seller.getEmail()) &&
                getAddress().equals(seller.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFullName(), getPhoneNumber(), getEmail(), getAddress());
    }
}
