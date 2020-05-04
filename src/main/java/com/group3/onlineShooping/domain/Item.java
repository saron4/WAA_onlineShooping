package com.group3.onlineShooping.domain;

import javax.persistence.*;
<<<<<<< HEAD
import java.util.Objects;
import com.group3.onlineShooping.domain.Product;
=======
>>>>>>> 5518508ad4453260268e25de0a8b80a1c60cbcb6

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private double itemPrice;
    private Long quantity ;

    @OneToOne
    private Product product ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", itemPrice=" + itemPrice + ", quantity=" + quantity + ", product=" + product + "]";
	}


<<<<<<< HEAD
    

   
=======
>>>>>>> 5518508ad4453260268e25de0a8b80a1c60cbcb6
}
