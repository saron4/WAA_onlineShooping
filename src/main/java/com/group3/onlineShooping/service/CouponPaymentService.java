package com.group3.onlineShooping.service;

import com.group3.onlineShooping.domain.CouponPayment;
import com.group3.onlineShooping.domain.Payment;

import java.util.List;

public interface CouponPaymentService {
    CouponPayment addPayment(CouponPayment payment);

    List<CouponPayment> getAll();

    List<CouponPayment> getAllByUserName(String username);

    CouponPayment getPayment(Long id);

    CouponPayment editPayment(CouponPayment payment);
}
