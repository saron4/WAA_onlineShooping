package com.group3.onlineShooping.serviceimpl;


import com.group3.onlineShooping.domain.Buyer;
import com.group3.onlineShooping.domain.Category;
import com.group3.onlineShooping.domain.Product;
import com.group3.onlineShooping.repository.ProductRepository;
import com.group3.onlineShooping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {


   private ProductRepository productRepository;

   public ProductServiceImpl () {
   }

   @Autowired
   public ProductServiceImpl(ProductRepository  productRepository){
      this.productRepository=productRepository;
   }

   @Override
   public List<Product> findAll() {
      return (List<Product>) productRepository.findAll();
   }

   @Override
   public Product save(Product product) {
      return productRepository.save(product);
   }

   @Override
   public Product find(Long id) {
      return productRepository.findById(id).get();
   }

   @Override
   public List<Product> findByCategory(Category category) {
      return null;
   }


   @Override
   public Product put(Product product) {
      return productRepository.save(product);
   }

}
