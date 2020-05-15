package com.group3.onlineShooping.service;

import com.group3.onlineShooping.domain.Buyer;
import com.group3.onlineShooping.domain.Seller;

import java.util.List;

public interface SellerService {

    public Seller addSeller(Seller seller);

    public List<Seller> getAll();

    public Seller getSeller(Long id) throws Exception;

    public Seller editSeller(Seller seller);

    public Seller findByEmail(String email);

    public Seller findById(Long id);
}
