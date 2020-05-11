package com.group3.onlineShooping.service;


import com.group3.onlineShooping.domain.Category;
import com.group3.onlineShooping.domain.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    public List<Product> findAll();
    public Product save(Product product);
    public Product find(Long id);
    public List<Product> findByCategory(Category category );
    public Product put(Product product);

}
