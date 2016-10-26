package com.java.local.main.model.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.java.local.main.model.order.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;

	@RequestMapping("/order/")
	public String process(@PathVariable String productId, @PathVariable long quantity) {
		orderService.processOrder(productId, quantity);
		return "redirect:/";
	}
}
