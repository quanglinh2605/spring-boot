package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Product;
import com.demo.entities.ProductInfo;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product, Integer> {
	// JPAQL
	
	@Query("from Product where status = :status")
	public List<Product> condition1(@Param("status") boolean status);
	@Query("from Product where price >= :min and price <= :max")
	public List<Product> condition2(@Param("min") double min,@Param("max") double max);
	@Query("from Product where name like %:keyword%")
	public List<Product> condition3(@Param("keyword") String keyword);
	// SQL
	
	@Query(value = "select * from product where price = :price",nativeQuery = true)
	public List<Product> condition4(@Param("price") double price);
	
	@Query(value = "select * from product order by id desc limit :n",nativeQuery = true)
	public List<Product> condition5(@Param("n") int n);
	
	@Query(value = "select * from product where name = :name",nativeQuery = true)
	public Product condition6(@Param("name") String name);
	
	@Query("select sum(quantity) from Product")
	public Long sum1();
	
	@Query("select sum(quantity*price) from Product")
	public double sum2();
	
	@Query("select count(id) from Product where status = :status")
	public Long count2(@Param("status") boolean status);
	
	@Query("select min(price) from Product")
	public double minPrice();
	
	@Query("select max(price) from Product")
	public double maxPrice();

	@Query("select avg(price) from Product")
	public double avg();
	
	@Query("select new com.demo.entities.ProductInfo(id, name, price, description) from Product")
	public List<ProductInfo> findAll2();
}
