package com.group3.onlineShooping.service;

import com.group3.onlineShooping.domain.Item;
import com.group3.onlineShooping.domain.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface ShoppingCartService {

    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    void checkout() throws Exception;

    BigDecimal getTotal();
}