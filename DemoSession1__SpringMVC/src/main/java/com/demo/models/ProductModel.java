package com.demo.models;

import java.util.ArrayList;
import java.util.List;

import com.demo.entities.Product;

public class ProductModel {

	public Product find() {
		return new Product("p01", "name 1", "thumb1.gif", 20);
	}

	public List<Product> findAll() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("p01", "name 1", "thumb1.gif", 20));
		products.add(new Product("p02", "name 2", "thumb2.gif", 21));
		products.add(new Product("p03", "name 3", "thumb3.gif", 22));
		return products;
	}

}