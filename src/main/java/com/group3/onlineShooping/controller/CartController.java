package com.group3.onlineShooping.controller;


import com.group3.onlineShooping.domain.*;
import com.group3.onlineShooping.exception.NoProductsFoundUnderCategoryException;
import com.group3.onlineShooping.exception.ProductUnavailableException;
import com.group3.onlineShooping.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.MathContext;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

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
        this.itemService = itemService;
        this.cartItemService = cartItemService;
    }

    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") Long productCategory, @ModelAttribute("item") Item item) {
        try {
            List<Category> categoryList = (List<Category>) categoryService.findAll();
            Category category = categoryService.findById(productCategory);
            List<Product> productList = productService.findAllByCategoryAndAvailable(category, true);
            model.addAttribute(productList);
            model.addAttribute(categoryList);
            if (productList == null || productList.isEmpty()) {
                throw new NoProductsFoundUnderCategoryException("No Product Found in This category , please Enter the correct Category");
            }

        } catch (Exception ex) {

        }
        return "cart/listProductCategory";
    }

    @GetMapping(value = "/productList")
    public String listProduct(@ModelAttribute("item") Item item, Model model) {
        List<Category> categoryList = (List<Category>) categoryService.findAll();
        List<Product> productList = productService.findAllByAvailable(true);
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

        if (!checkProduct(product, model, principal)) {
            return "cart/listProductCategory";
        }
        Long quantityCart;
        double totalAmount;
        String email = principal.getName();
        Product productResult = productService.find(product.getId());
        Item item = new Item();
        Buyer buyer = buyerService.findByEmail(email);
        List<Item> items = new ArrayList<>();
        //get cart by created
        CartItem cartItemBuyer = cartItemService.findByBuyerAndCartStatus(buyer, CartItem.CartItemStatus.Created);
        BigDecimal quantity = new BigDecimal(product.getCartQuantity(), MathContext.DECIMAL64);
        item.setItemPrice(quantity.multiply(productResult.getPrice()));
        if (cartItemBuyer == null) {
            cartItemBuyer = new CartItem();

        } else {
            List<Item> itemsListCart = cartItemBuyer.getItem();
            if (itemsListCart.size() >= 1) {
                for (Item itemCart : itemsListCart) {
                    if (itemCart.getProduct().getId() == product.getId()) {
                        quantityCart = itemCart.getQuantity() + product.getCartQuantity();
                        quantity = new BigDecimal(quantityCart, MathContext.DECIMAL64);
                        itemCart.setItemPrice(quantity.multiply(itemCart.getProduct().getPrice()));
                        itemCart.setQuantity(quantityCart);

                        itemService.save(itemCart);
                        return "redirect:/shoppingCart/cartList";
                    }

                }
            }

            item.setProduct(productResult);
            item.setQuantity(product.getCartQuantity());
            item.setCartItem(cartItemBuyer);

            itemService.save(item);
            return "redirect:/shoppingCart/cartList";
        }
        item.setProduct(productResult);
        item.setQuantity(product.getCartQuantity());
        items.add(item);
        cartItemBuyer.setItem(items);
        cartItemBuyer.setBuyer(buyer);
        item.setCartItem(cartItemBuyer);
        cartItemService.save(cartItemBuyer);
        return "redirect:/shoppingCart/cartList";
    }


    public boolean checkProduct(Product product, Model model, Principal principal) {
        Long quantity;
        String email = principal.getName();
        Buyer buyer = buyerService.findByEmail(email);
        //CartItem cartItemBuyer = cartItemService.findByBuyer(buyer);
        CartItem cartItemBuyer = cartItemService.findByBuyerAndCartStatus(buyer, CartItem.CartItemStatus.Created);


        if (cartItemBuyer == null) {
            return true;
        }
        List<Item> itemsList = cartItemBuyer.getItem();
        for (Item item : itemsList) {
            if (item.getProduct().getId() == product.getId()) {
                quantity = item.getQuantity() + product.getCartQuantity();
                if (quantity > item.getProduct().getAvailableInStor()) {
                    throw new ProductUnavailableException("Unfortunately, the following << " + item.getProduct().getTitle() + " >>  item(s) that you ordered are now out-of-stock.");
                }
            }
        }
        return true;
    }

    public void checkProductCart(Product product, Model model, Principal principal) {
        Long quantity;
        String email = principal.getName();
        Buyer buyer = buyerService.findByEmail(email);
        CartItem cartItemBuyer = cartItemService.findByBuyer(buyer);
        List<Item> itemsList = cartItemService.findByBuyer(buyer).getItem();
        for (Item item : itemsList) {
            if (item.getQuantity() > item.getProduct().getAvailableInStor()) {
                throw new IllegalArgumentException(new NoProductsFoundUnderCategoryException(item.getProduct().getTitle()));
            }

        }


    }


}
