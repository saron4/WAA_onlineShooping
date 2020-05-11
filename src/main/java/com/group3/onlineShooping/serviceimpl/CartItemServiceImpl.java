package com.group3.onlineShooping.serviceimpl;


import com.group3.onlineShooping.domain.Buyer;
import com.group3.onlineShooping.domain.CartItem;
import com.group3.onlineShooping.repository.CartItemRepository;
import com.group3.onlineShooping.service.CartItemService;
import com.group3.onlineShooping.service.CartItemService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

private CartItemRepository cartItemRepository  ;
public CartItemServiceImpl(CartItemRepository cartItemRepository){
   this.cartItemRepository=cartItemRepository;
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
}
