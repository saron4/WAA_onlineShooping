package com.group3.onlineShooping.domain;

import javax.persistence.Entity;
<<<<<<< HEAD
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class User {
	
	@Id
	@GeneratedValue
=======
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
>>>>>>> 5518508ad4453260268e25de0a8b80a1c60cbcb6
	private long id;
	
	private String userName;
	
	private String password;
<<<<<<< HEAD
	
	@OneToOne
	private Role role;

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
	
	
	

=======

	@OneToOne
	private Role  role;

	public User() {

	}
>>>>>>> 5518508ad4453260268e25de0a8b80a1c60cbcb6
}
