package com.group3.onlineShooping.service;


import com.group3.onlineShooping.domain.Product;
import com.group3.onlineShooping.domain.Review;
import com.group3.onlineShooping.domain.ReviewStatus;

import java.util.List;

public interface ReviewService {
    public List<Review> findAll();
    public Review save(Review review);
    public Review find(Long id);
    public Review put(Review review);
    public void delete(Review review);
    public List<Review> findAllByProduct(Product product);
    public List<Review> findAllByProductAndReviewStatus(Product product, ReviewStatus reviewStatus);


}
