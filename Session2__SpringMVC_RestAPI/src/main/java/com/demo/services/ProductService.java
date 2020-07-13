package com.demo.services;

import java.util.List;

import com.demo.entities.Product;
import com.demo.entities.ProductInfo;

public interface ProductService {
	public Product add(Product product);
	public Product save(Product product);
	public Product find(int id);
	public void delete(int id);
	public Iterable<Product> findAll();
	public List<Product> findbyPrice(double min, double max);
	public List<Product> findbyName(String keyword);
	public List<ProductInfo> findAll2();
}
