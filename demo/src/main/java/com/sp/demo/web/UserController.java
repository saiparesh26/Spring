package com.sp.demo.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/{userId}")
	public String displayUser(@PathVariable int userId) {
		return "User found: " + userId;
	}
	
	@RequestMapping("/{id}/invoices")
	public String displayUserInvoices(@PathVariable("id") int userId, 
			@RequestParam(value = "date", required = false) Date dateOrNull) {
		return "Invoice found for the user: " + userId + " on the date: " + dateOrNull;
	}
	
	@RequestMapping("/{userId}/items")
	public List<String> displayStringJson() {
		return Arrays.asList("Shows", "Laptop", "button");
	}
	
	@RequestMapping("/{userId}/products_as_json")
	public List<Product> displayProductsJson() {
		return Arrays.asList(new Product(1, "Shows", 200), 
							 new Product(2, "Watch", 500), 
						     new Product(3, "Gloves", 300));
		
	}
}
