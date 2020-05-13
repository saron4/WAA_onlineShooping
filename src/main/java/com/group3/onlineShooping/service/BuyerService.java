package com.group3.onlineShooping.service;

import com.group3.onlineShooping.domain.Buyer;

import java.util.List;

public interface BuyerService {

    public List<Buyer> findAll();
    public List<Buyer> getAllBuyer();
    public Buyer save(Buyer buyer);
    public Buyer find(Long id);
    public Buyer findByEmail(String email  );
    public Buyer put(Buyer buyer);
}
