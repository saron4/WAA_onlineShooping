package com.group3.onlineShooping.domain;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class User {
	@Id
	@GeneratedValue
	private long id;

	@Email(message = "{email.validation}")
	private String userName;


	@Size(min = 6, max = 50, message = "{Size.validation}")
	private String password;


	@Transient
	@Size(min = 6, max = 50, message = "{Size.validation}")
	private String matchingPassword;

//	@OneToOne
	@Transient
	private Role role;


	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", matchingPassword='" + matchingPassword + '\'' +
				", role=" + role +
				'}';
	}
}
