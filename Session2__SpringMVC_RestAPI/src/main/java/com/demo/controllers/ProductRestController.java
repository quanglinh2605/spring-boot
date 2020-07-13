package com.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Product;
import com.demo.entities.ProductInfo;
import com.demo.services.ProductService;

@RestController
@RequestMapping("api/product")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "findAll",method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Product>> findAll()
	{
		try {
			return new ResponseEntity<Iterable<Product>>(productService.findAll(), HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<Iterable<Product>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findAll2",method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ProductInfo>> findAll2()
	{
		try {
			return new ResponseEntity<List<ProductInfo>>(productService.findAll2(), HttpStatus.OK);	
		} catch (Exception e) {
			return new ResponseEntity<List<ProductInfo>>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "find/{id}",method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> findByID(@PathVariable("id") int id){
		try {
			return new ResponseEntity<Product>(productService.find(id),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findbyname/{keyword}",method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> findByID(@PathVariable("keyword") String keyword){
		try {
			return new ResponseEntity<List<Product>>(productService.findbyName(keyword),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "findbyprice/{min}/{max}",method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> findByPrice(@PathVariable("min") double min, @PathVariable("max") double max){
		try {
			return new ResponseEntity<List<Product>>(productService.findbyPrice(min, max),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "total/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> Total(@PathVariable("id") int id){
		try {
			Product product = productService.find(id);
			return new ResponseEntity<String>(String.valueOf(product.getQuantity() * product.getPrice()),HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> create(@RequestBody Product product){
		try {
			return new ResponseEntity<Product>(productService.save(product),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "update", method = RequestMethod.PUT,
			consumes = MimeTypeUtils.APPLICATION_JSON_VALUE,
			produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> update(@RequestBody Product product){
		try {
			return new ResponseEntity<Product>(productService.save(product),HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") int id){
		try {
			productService.delete(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}
	}
}
