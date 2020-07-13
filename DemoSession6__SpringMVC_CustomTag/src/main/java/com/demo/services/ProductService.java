package com.demo.services;

import java.util.List;

import com.demo.entities.Product;
import com.demo.entities.ProductInfo;

public interface ProductService {
	public Iterable<Product> findAll();	
	public List<ProductInfo> findAll2();
}
