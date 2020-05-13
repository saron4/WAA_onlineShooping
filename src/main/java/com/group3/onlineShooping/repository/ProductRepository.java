package com.group3.onlineShooping.repository;

import com.group3.onlineShooping.domain.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll(Pageable pageable);
    Product findOne(Long id);
}
