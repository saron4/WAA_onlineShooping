package com.group3.onlineShooping.repository;

import com.group3.onlineShooping.domain.Category;
import com.group3.onlineShooping.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    //List<Product> findAllByCategory(Category category);
}
