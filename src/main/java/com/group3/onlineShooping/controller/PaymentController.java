package com.group3.onlineShooping.controller;

import com.group3.onlineShooping.domain.BillingAddress;
import com.group3.onlineShooping.domain.Payment;
import com.group3.onlineShooping.domain.ShippingAddress;
import com.group3.onlineShooping.service.PaymentService;
import com.group3.onlineShooping.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping
    public String payment(Model model) {
        Payment payment = new Payment();
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setBillingAddress(new BillingAddress());
        payment.setShippingAddress(shippingAddress);

        model.addAttribute("payment", payment);
        System.out.println(payment);
        return "payment/payment";
    }

    @PostMapping
    public String payment(@Valid Payment payment, BindingResult result) {
        System.out.println(payment);
        if (result.hasErrors()) {

        }
        paymentService.addPayment(payment);
        return "payment/payment";
    }
}
