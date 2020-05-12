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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        order.setOrderDate(LocalDateTime.now());
        order.setPayment(paymentResult);
        order.setCartItem(cartItem);

        orderService.addOrder(order);
        return "redirect:/payment/paymentsuccess";
    }

    @GetMapping("/paymentsuccess")
    public String paymentSuccess() {
        return "payment/paymentsuccess";
    }


    @ModelAttribute("months")
    public List<String> months() {
        List<String> months = new ArrayList<>();
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        return months;
    }

    @ModelAttribute("days")
    public List<Integer> days() {
        return IntStream
                .iterate(1, i -> i + 1)
                .limit(31)
                .boxed()
                .collect(Collectors.toList());
    }

    @ModelAttribute("years")
    public List<Integer> years() {
        return IntStream
                .iterate(LocalDate.now().getYear(), i -> i + 1)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());
    }
}
