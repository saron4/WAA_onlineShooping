package com.group3.onlineShooping.serviceimpl;


import com.group3.onlineShooping.domain.Category;
import com.group3.onlineShooping.domain.Item;
import com.group3.onlineShooping.domain.Product;
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
   public void delete(Item item) {
       itemRepository.delete(item);
   }

}
