package com.group3.onlineShooping.repository;

import com.group3.onlineShooping.domain.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "SELECT p FROM  Product p WHERE p.category=:category AND p.isAvailable= :isAvailable")
    List<Product> findAllByCategoryAndAvailableIs(Category category, boolean isAvailable);

    @Query(value = "SELECT p FROM  Product p WHERE  p.isAvailable= :isAvailable")
    List<Product> findAllByAvailableIs(boolean isAvailable);

    @Query(value = "SELECT p FROM  Product p WHERE  p.seller= :seller")
    List<Product> findProductBySeller(Seller seller);

    @Modifying
    @Query("DELETE FROM Product p WHERE p.id = ?1")
    void deleteProductById(Long  productId);


}
