package com.group3.onlineShooping.domain;

import com.group3.onlineShooping.customvalidation.PasswordMatches;
import com.group3.onlineShooping.customvalidation.ValidEmail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    @NotNull(groups = {ValidationGroups.UpdateValidation.class})
    private Long id;
    @Size(min = 4, max = 100, message = "{Size.validation}", groups = {ValidationGroups.CreateValidation.class, ValidationGroups.UpdateValidation.class})
    private String firstName;
    @Size(min = 4, max = 100, message = "{Size.validation}", groups = {ValidationGroups.CreateValidation.class, ValidationGroups.UpdateValidation.class})
    private String lastName;

    @Email(message = "{email.validation}", groups = {ValidationGroups.CreateValidation.class, ValidationGroups.UpdateValidation.class})
    @ValidEmail(message = "{email.customerValidation}", groups = {ValidationGroups.CreateValidation.class})
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

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

}
