package com.group3.onlineShooping.controller;

import com.group3.onlineShooping.domain.Role;
import com.group3.onlineShooping.domain.Seller;
import com.group3.onlineShooping.service.RoleService;
import com.group3.onlineShooping.service.SellerService;
import com.group3.onlineShooping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashSet;
import java.util.Set;


@Controller
@RequestMapping("/seller")
public class SellerController {
    private SellerService sellerService;
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public SellerController(SellerService sellerService, UserService userService, RoleService roleService) {
        this.sellerService = sellerService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/registration")
    public String getRegistration(@ModelAttribute("seller") Seller seller) {
        return "seller/sellerRegistration";
    }

    @PostMapping(value = "/registration")
    public String saveSeller(@Validated @ModelAttribute("seller") Seller seller, BindingResult result, Model model,
                             RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "seller/sellerRegistration";
        }
        Role role = roleService.findByRoleName("SELLER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        seller.getUser().setUsername(seller.getEmail());
        seller.getUser().setActive(0);
        seller.getUser().setRoles(roles);
        userService.save(seller.getUser());
        Seller sellerResult = sellerService.addSeller(seller);
        redirectAttributes.addFlashAttribute("firstName", seller.getFullName());
        return "redirect:/login";
    }

}