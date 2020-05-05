package com.group3.onlineShooping.domain;

import com.group3.onlineShooping.customvalidation.PasswordMatches;
import com.group3.onlineShooping.customvalidation.ValidEmail;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@PasswordMatches
public class Buyer {
    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 4, max = 50, message = "{Size.validation}")
    private String firstName;
    @Size(min = 4, max = 50, message = "{Size.validation}")
    private String lastName;

    @Email(message = "{email.validation}")
    @ValidEmail(message = "{email.customerValidation}")
    private String email;

    private int coupons = 0;

    @OneToOne(fetch = FetchType.EAGER)
    @Valid
    private User user;

    public Buyer() {
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", coupons=" + coupons +
                ", user=" + user +
                '}';
    }

    public int getCoupons() {
        return coupons;
    }

    public void setCoupons(int coupons) {
        this.coupons = coupons;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Buyer buyer = (Buyer) o;
        return Objects.equals(id, buyer.id) && Objects.equals(firstName, buyer.firstName)
                && Objects.equals(lastName, buyer.lastName) && Objects.equals(email, buyer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }
}
