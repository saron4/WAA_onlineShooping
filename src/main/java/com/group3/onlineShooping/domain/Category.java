package com.group3.onlineShooping.domain;

import java.util.List;
import java.util.Set;

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
=======
import javax.persistence.*;
>>>>>>> 5518508ad4453260268e25de0a8b80a1c60cbcb6


@Entity
public class Category {

<<<<<<< HEAD
    @Id
    @GeneratedValue
    private Long categoryId;

    private String categoryName;

    @OneToMany
    @JoinColumn(name="categoryId") 
    private List<Product> products;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

	public Long getCategoryId() {
		return categoryId;
=======
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;
	
	private String categoryName;

	@ManyToOne
	private Product products;

	public String getCategoryName() {
		return categoryName;
>>>>>>> 5518508ad4453260268e25de0a8b80a1c60cbcb6
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

<<<<<<< HEAD
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
=======
	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
>>>>>>> 5518508ad4453260268e25de0a8b80a1c60cbcb6
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", products=" + products + "]";
	}



}
