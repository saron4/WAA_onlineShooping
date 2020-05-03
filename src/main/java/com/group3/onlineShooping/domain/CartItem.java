package com.group3.onlineShooping.domain;

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

}
