package com.group3.onlineShooping.controller;
import com.group3.onlineShooping.domain.Product;
import com.group3.onlineShooping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/market")
public class ProductController {

	private static String UPLOADED_FOLDER = "/Users/mahlet/Documents/GitHub/GroupProject/4WAA/WAA_onlineShooping/images/";

	private ProductService productService;
	@Autowired
	public ProductController(ProductService productService){
		this.productService=productService;
	}

	@RequestMapping("/products")
	public String list(Model model) {
		model.addAttribute("products", productService.findAll());
		return "products";
	}

	@RequestMapping("/products/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") Long productCategory) {
		model.addAttribute("products", productService.find(productCategory));
		return "products";
	}
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") Long productId, Model model) {
		model.addAttribute("product", productService.find(productId));
		return "product";
	}
	@GetMapping("/addProduct")
	public String SellerPage(@ModelAttribute("product") Product product ) {
		return "product/productForm";
	}

	@RequestMapping(value="/saveProduct",method=RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product,  Model model) {

		return null;
	}


}

