package com.group3.onlineShooping.controller;

import com.group3.onlineShooping.domain.Admin;
import com.group3.onlineShooping.domain.Review;
import com.group3.onlineShooping.domain.Role;
import com.group3.onlineShooping.domain.Seller;
import com.group3.onlineShooping.service.*;
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
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private AdminService adminService;
    private UserService userService;
    private RoleService roleService;
    private final SellerService sellerService;
    private final ReviewService reviewService;

    @Autowired
    public AdminController(AdminService adminService, UserService userService, RoleService roleService, SellerService sellerService, ReviewService reviewService) {
        this.adminService = adminService;
        this.userService = userService;
        this.roleService = roleService;
        this.sellerService = sellerService;
        this.reviewService = reviewService;
    }

    @GetMapping(value = "/registration")
    public String getRegistration(@ModelAttribute("admin") Admin admin) {
        return "admin/createForm";
    }

    @PostMapping(value = "/registration")
    public String saveAdmin(@Validated @ModelAttribute("admin") Admin admin, BindingResult result, Model model,
                            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "admin/createForm";
        }
        Role role = roleService.findByRoleName("ADMIN");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        admin.getUser().setUsername(admin.getEmail());
        admin.getUser().setActive(1);
        admin.getUser().setRoles(roles);
        userService.save(admin.getUser());
        Admin adminResult = adminService.save(admin);
        redirectAttributes.addFlashAttribute("firstName", admin.getFirstName());
        return "redirect:/login";
    }

    @GetMapping(value = "/seller_approval")
    public String sellerApproval(@ModelAttribute("admin") Admin admin) {
        return "admin/seller_approval";
    }

    @GetMapping(value = "/commet_approval")
    public String commentApproval(@ModelAttribute("admin") Admin admin) {
        return "admin/commet_approval";
    }


    @ModelAttribute("sellers")
    public List<Seller> sellers() {
        return sellerService.getAll();
    }

    @ModelAttribute("productComments")
    public List<Review> productComments() {
        return reviewService.findAll();
    }


}
