package com.group3.onlineShooping.domain;


import com.group3.onlineShooping.customvalidation.PasswordMatches;
import com.group3.onlineShooping.customvalidation.ValidEmail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(min = 4, max = 50, message = "{Size.validation}")
    private String firstName;
    @Size(min = 4, max = 50, message = "{Size.validation}")
    private String lastName;
    @Email(message = "{email.validation}")
//    @ValidEmail(message = "{email.customerValidation}")
    private String email;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_Id")
    @Valid
    private User user;
}

