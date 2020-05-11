package com.group3.onlineShooping.controller;


import com.group3.onlineShooping.domain.*;
import com.group3.onlineShooping.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/cartItem")
public class CartController {
    private ProductService productService;
    private CategoryService categoryService;
    private BuyerService buyerService;
    private CartItemService cartItemService;
    private ItemService itemService;

    @Autowired
    public CartController(ProductService productService, CategoryService categoryService, BuyerService buyerService, CartItemService cartItemService, ItemService itemService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.buyerService = buyerService;
        this.categoryService = categoryService;
        this.cartItemService = cartItemService;
    }

    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") Long productCategory, @ModelAttribute("item") Item item) {
        List<Product> productList = categoryService.findById(productCategory).getProducts();
        List<Category> categoryList = (List<Category>) categoryService.findAll();
        model.addAttribute(productList);
        model.addAttribute(categoryList);
        return "cart/listProductCategory";
    }

    @GetMapping(value = "/productList")
    public String listProduct(@ModelAttribute("item") Item item, Model model) {
        List<Category> categoryList = (List<Category>) categoryService.findAll();
        List<Product> productList = productService.findAll();
        model.addAttribute(productList);
        model.addAttribute(categoryList);
        return "cart/listProductCategory";
    }

    @RequestMapping("/viewDetails")
    public String displayDetailProduct(Model model, @RequestParam("productId") Long productId, @ModelAttribute("product")
            Product product) {
        Product productResult = productService.find(productId);
        model.addAttribute(productResult);
        return "cart/addShoppingCart";
    }

    @PostMapping(value = "/addCart")
    public String saveCart(Product product, Model model, Principal principal) {
        String email = principal.getName();
        Product productResult = productService.find(product.getId());
        Item item = new Item();
        BigDecimal quantity = new BigDecimal(product.getCartQuantity(), MathContext.DECIMAL64);
        item.setItemPrice(quantity.multiply(productResult.getPrice()));
        item.setProduct(productResult);
        item.setQuantity(product.getCartQuantity());
        Buyer buyer = buyerService.findByEmail(email);
        List<Item> items = new ArrayList<>();
        items.add(item);

       // CartItem cartItem= cartItemService.findByBuyer(buyer);


        CartItem cartItem = new CartItem();
        cartItem.setItem(items);
        cartItem.setBuyer(buyer);
        // cartItem.setTotalPrice();
        //List<Category> categoryList= (List<Category>) categoryService.findAll();
        //List<Product> productList=productService.findAll();
        //  model.addAttribute(productList);
        //  model.addAttribute(categoryList);
        System.out.println(item);

        System.out.println("##########" + cartItem);
        items.forEach(x -> System.out.println(x));

        cartItemService.save(cartItem);
        //itemService.save(item);
        List<Item> itemsList=cartItemService.findById(cartItem.getCartId()).getItem();
        model.addAttribute("itemsList",itemsList);
        System.out.print(itemsList);
        return "cart/shoppingCart";
    }
}
