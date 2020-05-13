package com.group3.onlineShooping.serviceimpl;


import com.group3.onlineShooping.domain.CartItem;
import com.group3.onlineShooping.domain.Category;
import com.group3.onlineShooping.domain.Item;
import com.group3.onlineShooping.domain.Product;
import com.group3.onlineShooping.repository.CategoryRepository;
import com.group3.onlineShooping.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

private CategoryRepository categoryRepository ;
public CategoryServiceImpl(CategoryRepository categoryRepository){
   this.categoryRepository=categoryRepository;
}

   @Override
   public Iterable<Category> findAll() {
      return categoryRepository.findAll();
   }

   @Override
   public Category save(Category category) {
      return categoryRepository.save(category);
   }

   @Override
   public Category findById(Long id) {
      return categoryRepository.findById(id).get();
   }

   @Override
   public Category put(Category category) {
      return categoryRepository.save(category);
   }



   @Override
   public void deleteProduct(Product product ) {
      System.out.println("*******************inside delete " +product);
      Category category = categoryRepository.findById(product.getCategory().getCategoryId()).get();
      System.out.println("*******************inside delete " +category);
      category.getProducts().remove(product);
      categoryRepository.flush();
   }

}
