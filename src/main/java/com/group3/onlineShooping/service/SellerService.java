package com.group3.onlineShooping.service;

import com.group3.onlineShooping.domain.Follower;
import com.group3.onlineShooping.domain.Seller;
import exception.SellerNotFoundException;

import java.util.List;

public interface SellerService {

    public Seller addSeller(Seller seller);

    public List<Seller> getAll();

    public Seller getSeller(Long id) throws Exception;

    public Seller editSeller(Seller seller);

    public Seller findById(Long id);

    public List<Seller> findAllBySeller(Long id, Follower.FollowerStatus followerStatus);

    public Seller findByEmail(String email) throws SellerNotFoundException;

    public Seller save(Seller seller);

    public Seller find(Long id);

    public Seller put(Seller seller);
    List<Seller> findAll();
}
