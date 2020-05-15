package com.group3.onlineShooping.domain;

import com.group3.onlineShooping.customvalidation.PasswordMatches;
import lombok.*;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;


@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@PasswordMatches
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	@Column(name = "username")
	private String username;

	@Size(min = 6, message = "{password}")
	@Column(name = "password")
	private String password;

	@Column(name = "active")
	private int active;

	@Transient
	@Size(min = 6, message = "{password}")
	private String matchingPassword;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;


}
