package com.java.local.main.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.local.main.model.domain.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/")
	public String getAllProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/products/{byCategory}")
	public String productsByCategory(@PathVariable("byCategory") String productCategory, Model model) {
		model.addAttribute("products", productService.getProductByCategory(productCategory));
		return "products";
	}
}
