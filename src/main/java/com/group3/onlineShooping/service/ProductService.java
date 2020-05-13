package com.group3.onlineShooping.service;


import com.group3.onlineShooping.domain.Category;
import com.group3.onlineShooping.domain.Product;
import com.group3.onlineShooping.domain.Seller;

import java.util.List;
import java.util.Map;

public interface ProductService {
    public List<Product> findAll();
    public Product save(Product product);
    public Product find(Long id);
    public List<Product> findByCategory(Category category );
    public Product put(Product product);
    public List<Product> findAllByCategoryAndAvailable(Category category, boolean isAvailable);
    public List<Product> findAllByAvailable(boolean isAvailable);
    public List<Product>  findProductBySeller(Seller seller);
    public void delete(Product product);
    public void deleteProductById(Long id);

}
