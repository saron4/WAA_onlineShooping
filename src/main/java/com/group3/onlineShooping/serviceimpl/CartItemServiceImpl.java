package com.group3.onlineShooping.serviceimpl;


import com.group3.onlineShooping.domain.Buyer;
import com.group3.onlineShooping.domain.CartItem;
import com.group3.onlineShooping.domain.Item;
import com.group3.onlineShooping.repository.CartItemRepository;
import com.group3.onlineShooping.service.CartItemService;
import com.group3.onlineShooping.service.CartItemService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

    private CartItemRepository cartItemRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public Iterable<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    @Override
    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem findById(Long id) {
        return cartItemRepository.findById(id).get();
    }

    @Override
    public CartItem put(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem findByBuyer(Buyer buyer) {
        return cartItemRepository.findCartItemByBuyer(buyer);
    }

    @Override
    public CartItem findByBuyerAndCartStatus(Buyer buyer, CartItem.CartItemStatus status) {
        return cartItemRepository.findCartItemByBuyerAndCartItemStatus(buyer,status);
    }

    @Override
    public void deleteItem(Item item) {
        CartItem cartItem = cartItemRepository.findById(item.getCartItem().getCartId()).get();
        cartItem.getItem().remove(item);
        cartItemRepository.flush();
    }


}
