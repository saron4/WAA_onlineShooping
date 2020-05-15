package com.group3.onlineShooping.serviceimpl;

import com.group3.onlineShooping.domain.Buyer;
import com.group3.onlineShooping.domain.Follower;
import com.group3.onlineShooping.domain.Seller;
import com.group3.onlineShooping.repository.SellerRepository;
import com.group3.onlineShooping.service.SellerService;
import exception.SellerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Seller addSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    // @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Seller> getAll() {
        /*Iterable<Seller> sellersIterable = sellerRepository.findAll();
        List<Seller> sellers = new ArrayList<>();
        while (sellersIterable.iterator().hasNext()) {
            sellers.add(sellersIterable.iterator().next());
        }
        return sellers;*/
        return (List<Seller>) sellerRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Seller getSeller(Long id) throws Exception {
        Optional<Seller> seller = sellerRepository.findById(id);
        if (!seller.isPresent()) {
            // a cusmtom excepttion has to be thrown
            System.out.println("Seller not found");
            throw new Exception("Seller not found");
        }
        return seller.get();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Seller editSeller(Seller seller) {
        Seller updatedSerller = sellerRepository.save(seller);
        return updatedSerller;
    }

    @Override
    public Seller findByEmail(String email) throws SellerNotFoundException {
        Seller seller = sellerRepository.findByEmail(email);
        if (seller == null)
            throw new SellerNotFoundException("Seller with the provided email doesn't exist");

        return seller;
    }

    @Override
    public Seller save(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public Seller find(Long id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        if (!seller.isPresent())
            throw new SellerNotFoundException("Seller with the provided email doesn't exist");
        return seller.get();
    }

    @Override
    public Seller put(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public List<Seller> findAll() {
        return (List<Seller>) sellerRepository.findAll();
    }

    @Override
    public List<Seller> findAllBySeller(Long id, Follower.FollowerStatus followerStatus) {
        System.out.println("########################" + id);
        return sellerRepository.findAllBySeller(followerStatus);
    }

    @Override
    public Seller findById(Long id) {
        return sellerRepository.findById(id).get();
    }


}
