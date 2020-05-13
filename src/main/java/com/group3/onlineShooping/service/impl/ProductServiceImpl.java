package com.group3.onlineShooping.service.impl;


import com.group3.onlineShooping.domain.Product;
import com.group3.onlineShooping.repository.ProductRepository;
import com.group3.onlineShooping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> findAllProductsPageable(Pageable pageable) {
        return (Page<Product>) productRepository.findAll(pageable);
    }
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}