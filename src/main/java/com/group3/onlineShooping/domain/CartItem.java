package com.group3.onlineShooping.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CartItem {
	@Id
	@GeneratedValue
	private Long cartId;

	@OneToOne
	private Buyer buyer;

	@OneToMany
	@JoinColumn(name = "cartId")
	private List<Item> item;

	private double totalPrice;

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "CartItem [cartId=" + cartId + ", buyer=" + buyer + ", item=" + item + ", totalPrice=" + totalPrice
				+ "]";
	}

	
}
