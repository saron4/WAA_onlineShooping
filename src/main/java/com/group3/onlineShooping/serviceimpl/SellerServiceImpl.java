package com.group3.onlineShooping.serviceimpl;

import com.group3.onlineShooping.domain.Buyer;
import com.group3.onlineShooping.domain.Seller;
import com.group3.onlineShooping.repository.SellerRepository;
import com.group3.onlineShooping.service.SellerService;
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

    private final SellerRepository sellerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Seller addSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Seller> getAll() {
        Iterable<Seller> sellersIterable = sellerRepository.findAll();
        List<Seller> sellers = new ArrayList<>();
        sellersIterable.forEach(sellers::add);
        return sellers;
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
        Seller updatedSeller = sellerRepository.save(seller);
        return updatedSeller;
    }

    @Override
    public Seller findByEmail(String email) {
        return sellerRepository.findByEmail(email);
    }

    @Override
    public Seller findById(Long id) {
        return sellerRepository.findById(id).get();
    }

}
