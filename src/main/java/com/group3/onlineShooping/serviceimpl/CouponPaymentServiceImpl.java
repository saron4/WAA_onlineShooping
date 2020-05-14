package com.group3.onlineShooping.serviceimpl;

import com.group3.onlineShooping.domain.CouponPayment;
import com.group3.onlineShooping.domain.Payment;
import com.group3.onlineShooping.repository.CouponPaymentRepository;
import com.group3.onlineShooping.repository.PaymentRepository;
import com.group3.onlineShooping.service.CouponPaymentService;
import com.group3.onlineShooping.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class CouponPaymentServiceImpl implements CouponPaymentService {

    @Autowired
    private CouponPaymentRepository paymentRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public CouponPayment addPayment(CouponPayment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<CouponPayment> getAll() {
        Iterable<CouponPayment> paymentIterable = paymentRepository.findAll();
        List<CouponPayment> payments = new ArrayList<>();
        paymentIterable.forEach(payments::add);
        return payments;
    }

    @Override
    public List<CouponPayment> getAllByUserName(String username) {
        List<CouponPayment> payments = getAll();
        return payments.stream()
                //.filter(payment -> payment.getCartItem().getBuyer().getEmail() == username)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public CouponPayment getPayment(Long id) {
        Optional<CouponPayment> payment = paymentRepository.findById(id);
        if (!payment.isPresent()) {
            // a cusmtom excepttion has to be thrown
            System.out.println("Payment not found");
            //throw new Exception("Payment not found");
        }
        return payment.get();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public CouponPayment editPayment(CouponPayment payment) {
        CouponPayment updatedPayment = paymentRepository.save(payment);
        return updatedPayment;
    }
}
