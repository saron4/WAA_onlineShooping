package com.group3.onlineShooping.controller;


import com.group3.onlineShooping.domain.Buyer;
import com.group3.onlineShooping.domain.Follower;
import com.group3.onlineShooping.domain.Product;
import com.group3.onlineShooping.domain.Seller;
import com.group3.onlineShooping.service.BuyerService;
import com.group3.onlineShooping.service.FollowerService;
import com.group3.onlineShooping.service.ProductService;
import com.group3.onlineShooping.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/follower")
public class FollowerController {
    private FollowerService followerService;
    private SellerService sellerService;
    private BuyerService buyerService;
    private ProductService productService;

    @Autowired
    public FollowerController(ProductService productService,FollowerService followerService, SellerService sellerService, BuyerService buyerService) {
        this.followerService = followerService;
        this.sellerService = sellerService;
        this.buyerService = buyerService;
        this.productService=productService;
    }


    @GetMapping("/getSeller")
    public String getSeller(Model model,Principal principal){
        List<Seller> sellerList;
        String email = principal.getName();
        Buyer buyer = buyerService.findByEmail(email);
        sellerList=sellerService.findAllBySeller(buyer.getId(), Follower.FollowerStatus.unfollow);
        System.out.println("########################");
        sellerList.forEach(x->System.out.println(x));
        model.addAttribute("sellerList",sellerList);
         return "buyer/followerSeller";
    }

    @GetMapping("ListProduct")
    public String getSellerListProduct(Model model,Principal principal,@RequestParam("sellerId") Long sellerId){
        List<Product> productList;
        String email = principal.getName();
        Seller seller=sellerService.find(sellerId);
        productList=productService.findProductBySeller(seller);
        if(productList!=null){
            model.addAttribute("productList",productList);
            //findProductBySeller

        }
        return "buyer/listProductSeller";

    }

    @GetMapping("/followerSave")
    public String saveFollower(Model model, @RequestParam("sellerId") Long sellerId, Principal principal, RedirectAttributes redirectAttributes){

        String email = principal.getName();
        Buyer buyer = buyerService.findByEmail(email);
        Seller seller=sellerService.find(sellerId);
        Follower follower= new Follower();
        follower.setBuyer(buyer);
        follower.setSeller(seller);
        System.out.println(" follower      "+follower);
        List<Seller> sellerList= new ArrayList<>();
        System.out.println(" buyer      "+buyer);
        followerService.save(follower);
        redirectAttributes.addFlashAttribute("successMessage","You are successful following this seller "+ seller.getFullName());

        // sellerList=followerService.findAllByProductAndReviewStatus(Follower.FollowerStatus.follow,buyer.getId());
       // sellerList.forEach(x->System.out.println(x));
       /* sellerList=sellerService.findAllBySeller(buyer.getId());
        System.out.println("########################");
        sellerList.forEach(x->System.out.println(x));
        model.addAttribute("sellerList",sellerList);
          return "buyer/followerSeller";*

        */
       return "redirect:/follower/getSeller";

    }


    @GetMapping("/getFollowed")
    public String getFollowed(Model model,Principal principal){
        List<Seller> sellerList;
        String email = principal.getName();
        Buyer buyer = buyerService.findByEmail(email);
        sellerList=followerService.findAllByProductAndReviewStatus(Follower.FollowerStatus.follow,buyer.getId());
        sellerList.forEach(x->System.out.println(x));
        model.addAttribute("sellerList",sellerList);
        return "buyer/followedListSeller";
    }



    @GetMapping("/UnfollowerSave")
    public String UnfollowerSave(Model model, @RequestParam("sellerId") Long sellerId, Principal principal, RedirectAttributes redirectAttributes){
        String email = principal.getName();
        Buyer buyer = buyerService.findByEmail(email);
        Seller seller=sellerService.find(sellerId);
        Follower follower=followerService.findFollowerByBuyerAndAndSeller(sellerId,buyer.getId());
        follower.setFollowerStatus(Follower.FollowerStatus.unfollow);
       // follower.setSeller(seller);
        //System.out.println(" follower      "+follower);
       // List<Seller> sellerList= new ArrayList<>();
        //System.out.println(" buyer      "+buyer);

        followerService.delete(follower);
        redirectAttributes.addFlashAttribute("successMessage","You are successful Unfollowing this seller "+ seller.getFullName());

        // sellerList=followerService.findAllByProductAndReviewStatus(Follower.FollowerStatus.follow,buyer.getId());
        // sellerList.forEach(x->System.out.println(x));
       /* sellerList=sellerService.findAllBySeller(buyer.getId());
        System.out.println("########################");
        sellerList.forEach(x->System.out.println(x));
        model.addAttribute("sellerList",sellerList);
          return "buyer/followerSeller";*

        */
        return "redirect:/follower/getFollowed";

    }


}
