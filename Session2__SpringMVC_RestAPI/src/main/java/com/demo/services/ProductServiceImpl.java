package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Product;
import com.demo.entities.ProductInfo;
import com.demo.repositories.ProductRepository;

@Service("productService")
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product add(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product find(int id) {
		return productRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

	@Override
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> findbyPrice(double min, double max) {
		return productRepository.findbyprice(min, max);
	}

	@Override
	public List<Product> findbyName(String keyword) {	
		return productRepository.findbyname(keyword);
	}

	@Override
	public List<ProductInfo> findAll2() {
		return productRepository.findAll2();
	}
}
