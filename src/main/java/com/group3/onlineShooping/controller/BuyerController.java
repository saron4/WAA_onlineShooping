package com.group3.onlineShooping.controller;

import com.group3.onlineShooping.domain.Buyer;
import com.group3.onlineShooping.domain.Role;
import com.group3.onlineShooping.service.BuyerService;
import com.group3.onlineShooping.service.RoleService;
import com.group3.onlineShooping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/buyer")
public class BuyerController {

    private BuyerService buyerService;
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public BuyerController(BuyerService buyerService, UserService userService, RoleService roleService) {
        this.buyerService = buyerService;
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/registration")
    public String getRegistration(@ModelAttribute("buyer") Buyer buyer) {
        return "buyer/buyerRegistrationForm";
    }

    @PostMapping(value = "/registration")
    public String saveBuyer(@Validated @ModelAttribute("buyer") Buyer buyer, BindingResult result, Model model,
                            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "buyer/buyerRegistrationForm";
        }
        Role role = roleService.findByRoleName("BUYER");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        buyer.getUser().setUsername(buyer.getEmail());
        buyer.getUser().setActive(1);
        buyer.getUser().setRoles(roles);
        userService.save(buyer.getUser());
        Buyer buyerResult = buyerService.save(buyer);
        System.out.println("*****************"+buyer);
        redirectAttributes.addFlashAttribute("firstName",buyer.getFirstName());
        return "redirect:/login";
    }


}
