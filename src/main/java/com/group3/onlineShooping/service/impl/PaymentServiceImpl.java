package com.group3.onlineShooping.service.impl;

import com.group3.onlineShooping.domain.Order;
import com.group3.onlineShooping.domain.Payment;
import com.group3.onlineShooping.repository.OrderRepository;
import com.group3.onlineShooping.repository.PaymentRepository;
import com.group3.onlineShooping.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service

@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Payment addPayment(Payment payment) {
       return paymentRepository.save(payment);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<Payment> getAll() {
        Iterable<Payment> paymentIterable = paymentRepository.findAll();
        List<Payment> payments = new ArrayList<>();
        while (paymentIterable.iterator().hasNext()) {
            payments.add(paymentIterable.iterator().next());
        }
        return payments;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Payment getPayment(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if (!payment.isPresent()) {
            // a cusmtom excepttion has to be thrown
            System.out.println("Payment not found");
            //throw new Exception("Payment not found");
        }
        return payment.get();
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Payment editPayment(Payment payment) {
        Payment updatedPayment = paymentRepository.save(payment);
        return updatedPayment;
    }
}
