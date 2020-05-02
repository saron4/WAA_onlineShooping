package com.group3.onlineShooping.domain;

import javax.persistence.OneToOne;

public class User {
	
	private long id;
	
	private String userName;
	
	private String password;

	@OneToOne
	private Role  role;

}
