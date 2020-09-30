package com.cg.gops;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;

import org.springframework.http.ResponseEntity;
import com.cg.gops.entity.Product;
import com.cg.gops.exception.ProductNameAlreadyExistException;
import com.cg.gops.exception.ProductNotFoundException;
import com.cg.gops.service.ProductService;
import com.cg.gops.util.ProductConstants;

/****************************************************
- File Name        : ProductTest.java
- Author           : Capgemini
- Creation Date    : 17-08-2020
- Description      : This Test class contains test cases using JUnit Testing
 ****************************************************/

@SpringBootTest
class ProductTest {

	@Autowired
	private ProductService productService;
	
	
	@Test
	public void testAddProduct1() throws ProductNameAlreadyExistException{
		String expected=ProductConstants.PRODUCT_ADDED;
		Product product=new Product("cols111","oilpastel",300,"red","dark shade","doms",5,"pastelcolors");
		String actual= productService.saveProduct(product);
		assertEquals(expected,actual);
		
	}

	@Test
	public void testAddProduct2() throws ProductNameAlreadyExistException{
		String expected=ProductConstants.PRODUCT_ADDED;
		Product product=new Product("cols111","oilpastel",300,"red","dark shade","doms",5,"pastelcolors");
		assertThrows(ProductNameAlreadyExistException.class, ()->productService.saveProduct(product));
		
	}
	@Test
	public void testProductByProductIdFound1() throws ProductNotFoundException{
		ResponseEntity<Product> product = productService.getProductById("i52")	;
		}
	@Test
	public void testProductByProductIdFound2() throws ProductNotFoundException{
		Assertions.assertThrows(ProductNotFoundException.class, ()->productService.getProductById("i59"));
		}
}

