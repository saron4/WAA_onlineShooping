package com.group3.onlineShooping.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	
	private String categoryName;

	@ManyToOne
	private Product products;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {

		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", products=" + products + "]";
	}



}
