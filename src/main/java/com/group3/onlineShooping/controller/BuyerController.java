package com.group3.onlineShooping.controller;

import com.group3.onlineShooping.domain.Buyer;
import com.group3.onlineShooping.domain.Role;
import com.group3.onlineShooping.service.BuyerService;
import com.group3.onlineShooping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/buyer")
public class BuyerController {

    private BuyerService buyerService;
    private UserService userService;
    @Autowired
    public BuyerController(BuyerService buyerService, UserService userService){
        this.buyerService=buyerService;
        this.userService=userService;
    }
    @GetMapping(value="/registration")
    public String getRegistration(@ModelAttribute("buyer") Buyer buyer) {
        return "buyer/buyerRegistrationForm";
    }

    @PostMapping(value="/registration")
    public String saveBuyer(@Validated @ModelAttribute("buyer") Buyer buyer, BindingResult result, Model model,
                            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "buyer/buyerRegistrationForm";
        }
        //phone.getProduct().setHotLine(phone);
       // phone = phoneService.save(phone); // insert & [ insert OR Update of phone]
        System.out.print(buyer);
       buyer.getUser().setUserName(buyer.getEmail());
        userService.save(buyer.getUser());
        Buyer buyerResult =buyerService.save(buyer);
        return "redirect:/";
    }

    public Buyer setAllObject(Buyer buyer){
        Buyer buyerResult= new Buyer();
        buyer.getUser().setUserName(buyer.getEmail());
        //Role role= new Role();
        //role.setRoleName("");
        //role.s
        return buyerResult;

    }
}
