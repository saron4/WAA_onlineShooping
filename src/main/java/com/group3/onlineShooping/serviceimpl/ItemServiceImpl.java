package com.group3.onlineShooping.serviceimpl;


import com.group3.onlineShooping.domain.*;
import com.group3.onlineShooping.repository.ItemRepository;
import com.group3.onlineShooping.repository.ProductRepository;
import com.group3.onlineShooping.service.ItemService;
import com.group3.onlineShooping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {


   private ItemRepository itemRepository;

   public ItemServiceImpl() {
   }

   @Autowired
   public ItemServiceImpl(ItemRepository  itemRepository){
      this.itemRepository=itemRepository;
   }

   @Override
   public List<Item> findAll() {
      return (List<Item>) itemRepository.findAll();
   }

   @Override
   public Item save(Item item) {
      return itemRepository.save(item);
   }

   @Override
   public Item find(Long id) {
      return itemRepository.findById(id).get();
   }

   @Override
   public Item put(Item item) {
      return itemRepository.save(item);
   }

   @Override
   public void delete(Item item) { itemRepository.deleteById(item.getId()); }

   @Override
   public void deleteItemByCartItem(Long cartId) {
      itemRepository.deleteItemByCartItem(cartId);
   }

   @Override
   public List<Product> findAllByItemStatusAndProduct(Item.ItemStatus itemStatus, Product product) {
      return itemRepository.findAllByItemStatusAndProduct(itemStatus,product);
   }

   @Override
   public void setItemStatus(Item.ItemStatus itemStatus, Long cartID) {
      itemRepository.setItemStatus(itemStatus,cartID);
   }


}
