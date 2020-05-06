package com.group3.onlineShooping.service;

import com.group3.onlineShooping.domain.Payment;
import com.group3.onlineShooping.domain.Seller;

import java.util.List;

public interface PaymentService {
    public void addPayment(Payment payment);

    public List<Payment> getAll();

    public Payment getPayment(Long id);

    public Payment editPayment(Payment payment);
}
