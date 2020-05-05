package com.group3.onlineShooping.repository;

import com.group3.onlineShooping.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
