package com.group3.onlineShooping.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

@Entity
public class Review {
	@Id
	@GeneratedValue
	private Long reviewId;
	
	@ManyToMany
	@JoinColumn(name="reviewId") 
	private List<Buyer> buyer ; 
	
	@ManyToMany
	@JoinColumn(name="reviewId") 
	private List<Product> product ; 
	
	private String comment ;
	
	
	public Long getReviewId() {
		return reviewId;
	}
	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}
	public List<Buyer> getBuyer() {
		return buyer;
	}
	public void setBuyer(List<Buyer> buyer) {
		this.buyer = buyer;
	}
	
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", buyer=" + buyer + ", product=" + product + ", comment=" + comment
				+ "]";
	}
	

}
