package com.group3.onlineShooping.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

	@OneToMany(cascade  = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "cartItem")
	private List<Item> item;

	private double totalPrice;
	@Enumerated(EnumType.STRING)
	private  CartItemStatus cartItemStatus = CartItemStatus.Created;

	public enum CartItemStatus {
		Created,
		ORDERED,
		SHIPPED,
		TRANSIT,
		DELIVERED,
		CANCELD
	}



}
