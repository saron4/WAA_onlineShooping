package com.group3.onlineShooping.repository;

import com.group3.onlineShooping.domain.Follower;
import com.group3.onlineShooping.domain.Seller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowerRepository extends CrudRepository<Follower, Long> {

   @Query(value = "SELECT f.seller FROM  Seller s ,  Follower f WHERE f.id=:id ")
    public List<Seller> findAllBySeller(Long id);



    @Query(value = "SELECT f FROM   Follower f WHERE f.seller.serllerId=:sellerId  and f.buyer.id=:buyerId ")
    public Follower findFollowerByBuyerAndAndSeller(Long sellerId, Long buyerId);


    @Query(value = "SELECT f.seller FROM  Follower f WHERE f.followerStatus=:followerStatus  AND f.buyer.id=:id")
    public List<Seller> findAllByProductAndReviewStatus(Follower.FollowerStatus followerStatus, Long id);

}

