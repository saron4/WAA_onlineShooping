package com.group3.onlineShooping.domain;

import javax.persistence.*;

/**
 * @author sara4
 *
 */
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String productNumber;
	
	private String title;
	 
	private String summary;
	 
	private String description;
	
	private double discount;
	
	private double price;

	@ManyToOne
	private SellerModel seller;
	
	private boolean isAvailable = true;
	
	private long availableInStor;

	@ManyToOne
	private Review review;

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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
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

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}
	 
	 
	
	
	
	 
	 
}
