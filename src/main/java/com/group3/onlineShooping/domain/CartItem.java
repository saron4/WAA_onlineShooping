package com.group3.onlineShooping.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;

import java.util.List;


import javax.persistence.*;
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class CartItem {
	@Id
	@GeneratedValue
	private Long cartId;

	@OneToOne
	private Buyer buyer;


	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "cartId")

	private List<Item> item;


	private double totalPrice;



}
