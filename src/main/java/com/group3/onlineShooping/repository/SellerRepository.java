package com.group3.onlineShooping.repository;

import com.group3.onlineShooping.domain.Follower;
import com.group3.onlineShooping.domain.Seller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Long> {
    Seller findByEmail(String email);

    @Query(value = "select s from Seller s left join fetch s.user")
    List<Seller> getAllSeller();

    //@Query(value = "SELECT s FROM  Seller s  LEFT  JOIN  Follower f  on f.seller.serllerId=s.serllerId  where   " +
       //     " f.seller.serllerId  IS NULL or f.followerStatus=: followerStatus")
   // public List<Seller> findAllBySeller(Long id, Follower.FollowerStatus followerStatus);

    @Query(value = "SELECT s FROM  Seller s  LEFT  JOIN  Follower f  on f.seller.serllerId=s.serllerId  where   " +
            " f.seller.serllerId  IS NULL or f.followerStatus = :followerStatus")
    public List<Seller> findAllBySeller(Follower.FollowerStatus followerStatus);

}