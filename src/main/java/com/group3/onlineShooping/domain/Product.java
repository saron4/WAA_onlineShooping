package com.group3.onlineShooping.domain;

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
=======
import javax.persistence.*;
>>>>>>> 5518508ad4453260268e25de0a8b80a1c60cbcb6

/**
 * @author sara4
 *
 */
@Entity
public class Product {
<<<<<<< HEAD
	@Id
	@GeneratedValue
=======

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
>>>>>>> 5518508ad4453260268e25de0a8b80a1c60cbcb6
	private Long id;

	private String productNumber;

	private String title;

	private String summary;

	private String description;

	private double price;

<<<<<<< HEAD
=======
	@ManyToOne
	private SellerModel seller;
	
>>>>>>> 5518508ad4453260268e25de0a8b80a1c60cbcb6
	private boolean isAvailable = true;

	private long availableInStor;

<<<<<<< HEAD
	@OneToOne
	private Seller seller;

	@Override
	public String toString() {
		return "Product [id=" + id + ", productNumber=" + productNumber + ", title=" + title + ", summary=" + summary
				+ ", description=" + description + ", price=" + price + ", isAvailable=" + isAvailable
				+ ", availableInStor=" + availableInStor + ", seller=" + seller + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
=======
	@ManyToOne
	private Review review;
>>>>>>> 5518508ad4453260268e25de0a8b80a1c60cbcb6

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public SellerModel getSeller() {
		return seller;
	}

	public void setSeller(SellerModel seller) {
		this.seller = seller;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public long getAvailableInStor() {
		return availableInStor;
	}

	public void setAvailableInStor(long availableInStor) {
		this.availableInStor = availableInStor;
	}

//	public Review getReview() {
//		return review;
//	}
//
//	public void setReview(Review review) {
//		this.review = review;
//	}

}
