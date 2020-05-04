package com.group3.onlineShooping.repository;

import com.group3.onlineShooping.domain.Product;
import com.group3.onlineShooping.domain.Seller;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Long> {
}
