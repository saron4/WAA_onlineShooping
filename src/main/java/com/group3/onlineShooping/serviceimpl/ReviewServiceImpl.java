package com.group3.onlineShooping.serviceimpl;

import com.group3.onlineShooping.domain.Product;
import com.group3.onlineShooping.domain.Review;
import com.group3.onlineShooping.domain.ReviewStatus;
import com.group3.onlineShooping.repository.ReviewRepository;
import com.group3.onlineShooping.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ReviewServiceImpl  implements ReviewService {

private ReviewRepository reviewRepository ;
    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAll() {
        return (List<Review>) reviewRepository.findAll();
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review find(Long id) {
        return reviewRepository.findById(id).get();
    }

    @Override
    public Review put(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void delete(Review review) {
         reviewRepository.delete(review);
    }

    @Override
    public List<Review> findAllByProduct(Product product) {
        return reviewRepository.findAllByProduct(product);



    }

    @Override
    public List<Review> findAllByProductAndReviewStatus(Product product, ReviewStatus reviewStatus) {
        return reviewRepository.findAllByProductAndReviewStatus(product,reviewStatus);

    }
}
