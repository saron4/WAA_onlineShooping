package com.group3.onlineShooping.service;

import com.group3.onlineShooping.domain.Payment;
import com.group3.onlineShooping.domain.Seller;

import java.util.List;

public interface PaymentService {
    Payment addPayment(Payment payment);

    List<Payment> getAll();

    List<Payment> getAllByUserName(String username);

    Payment getPayment(Long id);

    Payment editPayment(Payment payment);
}
