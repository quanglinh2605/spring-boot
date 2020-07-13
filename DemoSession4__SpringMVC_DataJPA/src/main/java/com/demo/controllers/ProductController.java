package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entities.Product;
import com.demo.services.ProductService;

@Controller()
@RequestMapping(value = {"","product"})
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = {"","index"},method = RequestMethod.GET)
	public String index(ModelMap modelMap) {
		modelMap.put("products", productService.findAll());
		return "product/index";
	}
	@RequestMapping(value = "index2",method = RequestMethod.GET)
	public String index2(ModelMap modelMap) {
		modelMap.put("product", productService.find(2));
		return "product/index2";
	}
	@RequestMapping(value = "index3",method = RequestMethod.GET)
	public String index3(ModelMap modelMap) {
		Product product = new Product();
		product.setName("ABC");
		product.setPrice(5);
		product.setQuantity(2);
		product.setDescription("good");
		product.setStatus(true);
		product = productService.save(product);
		System.out.println("id: " + product.getId());
		modelMap.put("product", productService.find(2));
		return "redirect:/product/index";
	}
	@RequestMapping(value = "index4",method = RequestMethod.GET)
	public String index4(ModelMap modelMap) {
		Product product = productService.find(12);
		product.setName("DEF");
		product.setPrice(48);
		product.setQuantity(7);
		product.setDescription("good");
		product.setStatus(false);
		product = productService.save(product);
		System.out.println("id: " + product.getId());
		modelMap.put("products", productService.findAll());
		return "redirect:/product/index";
	}
	@RequestMapping(value = "index5",method = RequestMethod.GET)
	public String index5(ModelMap modelMap) {
		productService.delete(12);		
		modelMap.put("products", productService.findAll());
		return "product/index";
	}
	@RequestMapping(value = "index6",method = RequestMethod.GET)
	public String index6(ModelMap modelMap) {				
		modelMap.put("products", productService.condition1(true));
		return "product/index";
	}
	@RequestMapping(value = "index7",method = RequestMethod.GET)
	public String index7(ModelMap modelMap) {				
		modelMap.put("products", productService.condition2(5,10));
		return "product/index";
	}
	@RequestMapping(value = "index8",method = RequestMethod.GET)
	public String index8(ModelMap modelMap) {				
		modelMap.put("products", productService.condition3("no"));
		return "product/index";
	}
	@RequestMapping(value = "index9",method = RequestMethod.GET)
	public String index9(ModelMap modelMap) {				
		modelMap.put("products", productService.condition4(7));
		return "product/index";
	}
	@RequestMapping(value = "index10",method = RequestMethod.GET)
	public String index10(ModelMap modelMap) {				
		modelMap.put("products", productService.condition5(3));
		return "product/index";
	}
	@RequestMapping(value = "index11",method = RequestMethod.GET)
	public String index11(ModelMap modelMap) {				
		modelMap.put("product", productService.condition6("nokia 1"));
		return "product/index2";
	}
	@RequestMapping(value = "index12",method = RequestMethod.GET)
	public String index12(ModelMap modelMap) {				
		modelMap.put("sum1", productService.sum1());
		modelMap.put("sum2", productService.sum2());
		modelMap.put("count1", productService.count());
		modelMap.put("count2", productService.count2(true));
		modelMap.put("minPrice", productService.minPrice());
		modelMap.put("maxPrice", productService.maxPrice());
		modelMap.put("avgPrice", productService.avgPrice());
		return "product/index12";
	}
	
	@RequestMapping(value = "index13",method = RequestMethod.GET)
	public String index13(ModelMap modelMap) {				
		modelMap.put("products", productService.findAll2());
		return "product/index13";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		modelMap.put("product", new Product());
		return "product/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(@ModelAttribute("product") Product product) {
		productService.save(product);
		return "redirect:/product/index";
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String add(@PathVariable("id") int id) {
		productService.delete(id);
		return "redirect:/product/index";
	}
	
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id,ModelMap modelMap) {
		modelMap.put("product", productService.find(id));
		return "product/edit";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String edit(@ModelAttribute("product") Product product) {
		productService.save(product);
		return "redirect:/product/index";
	}
	
	@RequestMapping(value = "Search", method = RequestMethod.GET)
	public String Search(@RequestParam("keyword") String keyword, ModelMap modelMap) {
		modelMap.put("products", productService.condition3(keyword));
		modelMap.put("keyword", keyword);
		return "product/index";
	}
}