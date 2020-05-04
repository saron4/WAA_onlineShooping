package com.group3.onlineShooping.domain;

<<<<<<< HEAD
import java.util.List;

import javax.persistence.*;

@Entity
public class CartItem {
	@Id
	@GeneratedValue
	private Long cartId;
	@OneToOne
	private Buyer buyer;
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cartItem_cartId")
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

	public CartItem() {
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

	
=======
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Product product;
    private Integer quantity;


     public CartItem() {
     }

     public Long getId() {
         return id;
     }

     public void setId(Long id) {
         this.id = id;
     }

     public Product getProduct() {
         return product;
     }

     public void setProduct(Product product) {
         this.product = product;
     }

     public Integer getQuantity() {
         return quantity;
     }

     public void setQuantity(Integer quantity) {
         this.quantity = quantity;
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(id, cartItem.id) &&
                Objects.equals(product, cartItem.product) &&
                Objects.equals(quantity, cartItem.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, quantity);
    }

>>>>>>> 5518508ad4453260268e25de0a8b80a1c60cbcb6
}
