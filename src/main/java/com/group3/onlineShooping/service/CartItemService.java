package com.group3.onlineShooping.service;

import com.group3.onlineShooping.domain.Buyer;
import com.group3.onlineShooping.domain.CartItem;
import com.group3.onlineShooping.domain.Item;


public interface CartItemService {
    public Iterable<CartItem> findAll();
    public CartItem save(CartItem cartItem);
    public CartItem findById(Long id);
    public CartItem put(CartItem cartItem);
    public CartItem findByBuyer(Buyer buyer);
    public CartItem findByBuyerAndCartStatus(Buyer buyer, CartItem.CartItemStatus status) ;
    public void deleteItem(Item item);




}
