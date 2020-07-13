package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.models.ProductModel;

@Controller
@RequestMapping("product")
public class ProductController {

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		ProductModel productModel = new ProductModel();
		modelMap.put("product", productModel.find());
		modelMap.put("products", productModel.findAll());
		return "product/index";
	}
	
}
