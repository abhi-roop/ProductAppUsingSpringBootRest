package com.cts.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	/*
	 * public abstract String saveProduct(Product product);
	 * 
	 * public abstract String updateProduct(Product product);
	 * 
	 * public abstract String removeProduct(int productId);
	 * 
	 * public abstract Optional<Product> getProduct(int productId);
	 * 
	 * public abstract List<Product> getAllProducts();
	 * 
	 * public abstract List<Product> getAllProductsBetween(int initialPrice, int
	 * finalPrice);
	 * 
	 * public abstract List<Product> getAllProductsByCategory(String category);
	 * 
	 * public abstract List<Product> getAllProductsAbovePrice(int price);
	 */
	/*
	 * public abstract String saveProduct(Product product); public abstract String
	 * saveProduct(Product product); public abstract String saveProduct(Product
	 * product); public abstract String saveProduct(Product product);
	 */
	public abstract List<Product> findByProductPriceBetween(int intialPrice, int finalPrice);
	
	public abstract List<Product> findByProductCategory(String category);
	
}
