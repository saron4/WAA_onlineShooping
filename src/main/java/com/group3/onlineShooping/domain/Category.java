ackage com.group3.onlineShooping.domain;

import java.util.Set;

import javax.persistence.Entity;

import com.group3.onlineShooping.domain.Product;

@Entity
public class Category {

    private Long categoryId;

    private String categoryName;

    private Prdoduct products;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Prdoduct getProducts() {
        return products;
    }

    public void setProducts(Prdoduct products) {
        this.products = products;
    }





}