package com.group3.onlineShooping.repository;

import com.group3.onlineShooping.domain.CouponPayment;
import com.group3.onlineShooping.domain.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CouponPaymentRepository extends CrudRepository<CouponPayment, Long> {
}