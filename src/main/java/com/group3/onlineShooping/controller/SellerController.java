package com.group3.onlineShooping.controller;

import com.group3.onlineShooping.domain.Buyer;
import com.group3.onlineShooping.domain.Seller;
import com.group3.onlineShooping.service.BuyerService;
import com.group3.onlineShooping.service.RoleService;
import com.group3.onlineShooping.service.SellerService;
import com.group3.onlineShooping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    private SellerService sellerService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/registration")
    public String getRegistration(@ModelAttribute("seller") Seller seller) {
        return "seller/sellerRegistrationForm";
    }


}
