package com.group3.onlineShooping.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class Role {
	@Id
	@GeneratedValue
	private Long id;
	private String roleName;

 enum RoleType{
		ADMIN ,SELLER,BUYER
 }
}
