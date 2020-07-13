package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Product;
import com.demo.entities.ProductInfo;
import com.demo.repositories.ProductRepository;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product find(int id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void delete(int id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> condition1(boolean status) {
		// TODO Auto-generated method stub
		return productRepository.condition1(status);
	}

	@Override
	public List<Product> condition2(double min, double max) {
		// TODO Auto-generated method stub
		return productRepository.condition2(min, max);
	}

	@Override
	public List<Product> condition3(String keyword) {
		// TODO Auto-generated method stub
		return productRepository.condition3(keyword);
	}

	@Override
	public List<Product> condition4(double price) {
		// TODO Auto-generated method stub
		return productRepository.condition4(price);
	}

	@Override
	public List<Product> condition5(int n) {
		// TODO Auto-generated method stub
		return productRepository.condition5(n);
	}

	@Override
	public Product condition6(String name) {
		// TODO Auto-generated method stub
		return productRepository.condition6(name);
	}

	@Override
	public Long sum1() {
		// TODO Auto-generated method stub
		return productRepository.sum1();
	}

	@Override
	public double sum2() {
		// TODO Auto-generated method stub
		return productRepository.sum2();
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return productRepository.count();
	}

	@Override
	public long count2(boolean status) {
		// TODO Auto-generated method stub
		return productRepository.count2(status);
	}

	@Override
	public double minPrice() {
		// TODO Auto-generated method stub
		return productRepository.minPrice();
	}

	@Override
	public double maxPrice() {
		// TODO Auto-generated method stub
		return productRepository.maxPrice();
	}

	@Override
	public double avgPrice() {
		// TODO Auto-generated method stub
		return productRepository.avg();
	}

	@Override
	public List<ProductInfo> findAll2() {
		// TODO Auto-generated method stub
		return productRepository.findAll2();
	}

}
