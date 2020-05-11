package com.group3.onlineShooping.service;


import com.group3.onlineShooping.domain.Category;

import java.util.Optional;

public interface CategoryService {
    public Iterable<Category> findAll();
    public Category save(Category category);
    public Category findById(Long id);
    public Category put(Category category);

}
