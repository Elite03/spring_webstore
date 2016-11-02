package com.java.local.main.model.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.java.local.main.model.domain.Product;
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

	@RequestMapping(value = "/filter/{byCriteria}")
	public String getProdutsByFilter(@MatrixVariable(pathVar = "byCriteria") Map<String, List<String>> filterParms,
			Model model) {
		model.addAttribute(productService.getProductsByFilter(filterParms));
		System.out.println(productService.getProductsByFilter(filterParms));
		return "products";
	}

	@RequestMapping("/product")
	public String getById(@RequestParam("id") String productId, Model model) {
		System.out.println(productService.getProductById(productId));
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProduct_GET(Model model) {
		Product product = new Product();
		model.addAttribute("newProduct", product);
		return "addProduct";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProduct_Post(@ModelAttribute("newProduct") Product product, BindingResult result,
			HttpServletRequest request) {
		MultipartFile imageFile = product.getProductImage();
		String[] suppressedFeilds = result.getSuppressedFields();
		String rootPath = request.getServletContext().getRealPath("/");

		if (suppressedFeilds.length > 0)
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFeilds));
		if (imageFile != null & !imageFile.isEmpty()) {
			try {
				imageFile.transferTo(new File(rootPath + "\\images\\" + product.getProductId() + ".png"));
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException("productSaving failed" + e);
			}
		}
		productService.addProduct(product);
		return "redirect:/";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("unitsInOrder", "discontinued");
	}
}
