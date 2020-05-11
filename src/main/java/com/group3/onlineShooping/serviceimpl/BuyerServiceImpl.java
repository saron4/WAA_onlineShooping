package com.group3.onlineShooping.serviceimpl;

import com.group3.onlineShooping.domain.Buyer;
import com.group3.onlineShooping.repository.BuyerRepository;
import com.group3.onlineShooping.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BuyerServiceImpl implements BuyerService {

    private BuyerRepository buyerRepository;

    @Autowired
    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    @Override
    public List<Buyer> findAll() {
        return (List<Buyer>) buyerRepository.findAll();
    }

    @Override
    public List<Buyer> getAllBuyer() {
        return buyerRepository.getAllBuyer();
    }

    @Override
    public Buyer save(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Override
    public Buyer find(Long id) {
        return buyerRepository.findById(id).get();
    }

    @Override
    public Buyer findByEmail(String email) {
        return buyerRepository.findByEmail(email);
    }

    @Override
    public Buyer put(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

}
