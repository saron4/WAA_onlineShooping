package com.group3.onlineShooping.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author sara4
 *
 */
@Entity
public class Product {
	@Id
	@GeneratedValue
	private Long id;

	private String productNumber;

	private String title;

	private String summary;

	private String description;

	private double price;

	private boolean isAvailable = true;

	private long availableInStor;

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

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
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
