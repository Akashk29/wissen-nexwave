package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Controller
public class ProductController_v2 {
	
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(value = "/api/products", method = RequestMethod.GET)
	public @ResponseBody Product getProducts() {
		List<Product> products = productRepository.findAll();
		return products.get(0);
	}


}
