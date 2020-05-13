package com.group3.onlineShooping.service;


import com.group3.onlineShooping.domain.Category;
import com.group3.onlineShooping.domain.Product;

import java.net.PortUnreachableException;
import java.util.Optional;

public interface CategoryService {
    public Iterable<Category> findAll();
    public Category save(Category category);
    public Category findById(Long id);
    public Category put(Category category);
    public  void deleteProduct(Product product);

}
