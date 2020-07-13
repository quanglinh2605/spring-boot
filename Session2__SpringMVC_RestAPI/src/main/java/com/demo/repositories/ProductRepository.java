package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Product;
import com.demo.entities.ProductInfo;

@Repository("productRepository")
public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	@Query("select new com.demo.entities.ProductInfo(id, name, price, description) from Product")
	public List<ProductInfo> findAll2();
	
	@Query("from Product where name like %:keyword%")
	public List<Product> findbyname(@Param("keyword") String keyword);

	@Query("from Product where price >= :min and price <= :max")
	public List<Product> findbyprice(@Param("min") double min,@Param("max") double max );
	
}
