package com.demo.services;

import java.util.List;

import com.demo.entities.Product;
import com.demo.entities.ProductInfo;

public interface ProductService {
	public Iterable<Product> findAll();
	public Product find(int id);
	public Product save(Product product);
	public void delete(int id);
	public List<Product> condition1(boolean status);
	public List<Product> condition2(double min, double max);
	public List<Product> condition3(String keyword);
	public List<Product> condition4(double price);
	public List<Product> condition5(int n);
	public Product condition6(String name);
	public Long sum1();
	public double sum2();
	public long count();
	public long count2(boolean status);
	public double minPrice();
	public double maxPrice();
	public double avgPrice();
	public List<ProductInfo> findAll2();
}
