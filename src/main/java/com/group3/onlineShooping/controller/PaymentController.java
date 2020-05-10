package com.group3.onlineShooping.controller;

import com.group3.onlineShooping.domain.*;
import com.group3.onlineShooping.service.OrderService;
import com.group3.onlineShooping.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;
    @Autowired
    OrderService orderService;

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
        payment.setTotalPrice(2000.21);
        Payment paymentResult = paymentService.addPayment(payment);
        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setPayment(paymentResult);

        //  TODO:
//        Buyer buyer = new Buyer();
//        buyer.setCoupons(1);
//        buyer.setEmail("sample@gmail.com");
//        buyer.setFirstName("Test");
//        buyer.setLastName("Test LAst");
//        User user = new User();
//        user.setPassword("pasword");
//        Role role = new Role();
//        role.setRoleName("Role");
//        user.setRole(role);
//        buyer.setUser(user);
//        order.setBuyer(buyer);
        CartItem cartItem = new CartItem();
//        cartItem.setBuyer(buyer);
        cartItem.setTotalPrice(23423);
        List<Item> itemList = new ArrayList<>();
        Item item = new Item();
        item.setItemPrice(1222);
        item.setQuantity(2L);
        Product product = new Product();
        product.setAvailable(true);
        product.setAvailableInStor(10);
        product.setDescription("this is description");
        product.setPrice(232233);
        product.setProductNumber("12312312");
        product.setSummary("this is summary");
        product.setTitle("title");
        Seller seller = new Seller();
        seller.setEmail("gmail.comd");
        seller.setFullName("Full name");
        Address address = new Address();
        address.setCity("Fairfield");
        address.setState("IA");
        address.setStreet("1000N");
        address.setZip("52323");
        seller.setAddress(address);
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setNumber("234324");
        phoneNumber.setAreaCode("234");
        phoneNumber.setPrefix("34");
        seller.setPhoneNumber(phoneNumber);
        product.setSeller(seller);
        item.setProduct(product);
        cartItem.setItem(itemList);
        order.setCartItem(cartItem);

        Order order1 = orderService.addOrder(order);
        return "payment/paymentsuccess";
    }
}
