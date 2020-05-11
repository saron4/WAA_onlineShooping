package com.group3.onlineShooping.controller;

import com.group3.onlineShooping.domain.*;
import com.group3.onlineShooping.service.CartItemService;
import com.group3.onlineShooping.service.OrderService;
import com.group3.onlineShooping.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;
    private final OrderService orderService;
    private final CartItemService cartItemService;

    @Autowired
    public PaymentController(PaymentService paymentService, @Qualifier("OrderServiceImpl") OrderService orderService, CartItemService cartItemService) {
        this.paymentService = paymentService;
        this.orderService = orderService;
        this.cartItemService = cartItemService;
    }

    @GetMapping("/{id}")
    public String payment(@PathVariable("id") Long id, Model model) {
        CartItem cartItem = cartItemService.findById(id);
        Payment payment = new Payment();
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setBillingAddress(new BillingAddress());
        payment.setShippingAddress(shippingAddress);
        payment.setCartItem(cartItem);
        payment.setTotalPrice(cartItem.getTotalPrice());
        model.addAttribute("payment", payment);

        return "payment/payment";
    }

    @PostMapping
    public String payment(@Valid Payment payment, BindingResult result, Model model) {
        Long id = payment.getCartItem().getCartId();
        CartItem cartItem = cartItemService.findById(id);
        payment.setTotalPrice(cartItem.getTotalPrice());

        if (result.hasErrors()) {
            payment.setCartItem(cartItem);
            model.addAttribute("payment", payment);
            return "payment/payment";
        }

        Payment paymentResult = paymentService.addPayment(payment);
        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setPayment(paymentResult);
        order.setCartItem(cartItem);

        orderService.addOrder(order);
        return "redirect:/payment/paymentsuccess";
    }

    @GetMapping("/paymentsuccess")
    public String paymentSuccess() {
        return "payment/paymentsuccess";
    }

}
