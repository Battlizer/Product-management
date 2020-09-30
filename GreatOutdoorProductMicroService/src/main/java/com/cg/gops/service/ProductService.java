package com.cg.gops.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.gops.entity.Product;
import com.cg.gops.exception.ProductNameAlreadyExistException;
import com.cg.gops.exception.ProductNotFoundException;

public interface ProductService {


		public String saveProduct(Product product)throws ProductNameAlreadyExistException;
		
		public String removeProduct(String productId) throws ProductNotFoundException;
		
		public List<Product> getAllProducts(String productId);
		
		public ResponseEntity<Product> getProductById(String productId) throws ProductNotFoundException;

		public boolean editProduct(Product product);
}
