package com.group3.onlineShooping.service;


import com.group3.onlineShooping.domain.Follower;
import com.group3.onlineShooping.domain.Product;
import com.group3.onlineShooping.domain.Review;
import com.group3.onlineShooping.domain.Seller;


import java.util.List;

public interface FollowerService {
    public List<Follower> findAll();
    public Follower save(Follower follower);
    public Follower find(Long id);
    public Follower put(Follower follower);
    public void delete(Follower follower);
    public List<Seller> findAllBySeller(Long Id);
    public List<Seller> findAllByProductAndReviewStatus(Follower.FollowerStatus followerStatus, Long id);
    public Follower findFollowerByBuyerAndAndSeller(Long sellerId, Long buyerId);


}
