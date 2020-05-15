package com.group3.onlineShooping.domain;

import com.group3.onlineShooping.customvalidation.PasswordMatches;
import com.group3.onlineShooping.customvalidation.ValidEmail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.validation.constraints.Email;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 4, max = 100, message = "{Size.validation}")
    private String firstName;
    @Size(min = 4, max = 100, message = "{Size.validation}")
    private String lastName;

    @Email(message = "{email.validation}")
    @ValidEmail(message = "{email.customerValidation}")
    private String email;
    private Integer coupons = 0;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_Id")
    @Valid
    private User user;
/*
    @ManyToMany
    @JoinTable (name="Follower")
    private List<Seller> seller;*/

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Review> reviews;

}
