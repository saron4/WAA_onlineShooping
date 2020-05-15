package com.group3.onlineShooping.repository;

import com.group3.onlineShooping.domain.Category;
import com.group3.onlineShooping.domain.Product;
import com.group3.onlineShooping.domain.Review;
import com.group3.onlineShooping.domain.ReviewStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

   @Query(value = "SELECT r FROM  Review r WHERE r.product=:product ")
    public List<Review> findAllByProduct(Product product);


    @Query(value = "SELECT r FROM  Review r WHERE r.product=:product  AND r.reviewStatus=:reviewStatus")
    public List<Review> findAllByProductAndReviewStatus(Product product, ReviewStatus reviewStatus);

}

