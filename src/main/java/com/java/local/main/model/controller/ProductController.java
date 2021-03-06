package com.java.local.main.model.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.java.local.main.classic.spring.validator.ProductValidator;
import com.java.local.main.model.domain.Product;
import com.java.local.main.model.domain.service.ProductService;
import com.java.local.main.model.exception.NoProductFound;
import com.java.local.main.model.exception.NoProductFoundUnderCategory;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductValidator productValidator;

	@RequestMapping(value = "/")
	public String getAllProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/products/{byCategory}")
	public String productsByCategory(@PathVariable("byCategory") String productCategory, Model model) {
		List<Product> products = productService.getProductByCategory(productCategory);
		if (products.isEmpty() || products.size() <= 0 || products.contains(null))
			throw new NoProductFoundUnderCategory();
		model.addAttribute("products", productService.getProductByCategory(productCategory));
		return "products";
	}

	@RequestMapping(value = "/filter/{byCriteria}")
	public String getProdutsByFilter(@MatrixVariable(pathVar = "byCriteria") Map<String, List<String>> filterParms,
			Model model) {
		model.addAttribute(productService.getProductsByFilter(filterParms));
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
	public String addProduct_Post(@ModelAttribute("newProduct") @Valid Product product, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors())
			return "addProduct";
		MultipartFile imageFile = product.getProductImage();
		String[] suppressedFeilds = result.getSuppressedFields();
		String rootPath = request.getServletContext().getRealPath("/");

		if (suppressedFeilds.length > 0)
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFeilds));
		if (imageFile != null && !imageFile.isEmpty()) {
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
		binder.setAllowedFields("productId", "name", "unitPrice", "description", "manufacturer", "category",
				"unitsInStock", "condition", "productImage");
		binder.setValidator(productValidator);

	}

	@ExceptionHandler(NoProductFound.class)
	public String errorHandler(Model model, NoProductFound execption, HttpServletRequest request) {
		model.addAttribute("invalidProductId", execption.getMessage());
		model.addAttribute("exception", execption);
		model.addAttribute("url", request.getRequestURL() + "?" + request.getQueryString());
		return "productNotFound";
	}
}
