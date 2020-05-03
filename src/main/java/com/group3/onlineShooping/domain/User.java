package com.group3.onlineShooping.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	private long id;
	
	private String userName;
	
	private String password;

	@OneToOne
	private Role  role;

	public User() {

	}
}
