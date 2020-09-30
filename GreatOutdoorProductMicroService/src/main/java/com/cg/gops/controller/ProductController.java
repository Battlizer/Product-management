package com.cg.gops.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import com.cg.gops.dto.SuccessMessage;
import com.cg.gops.entity.Product;
import com.cg.gops.exception.ProductNameAlreadyExistException;
import com.cg.gops.exception.ProductNotFoundException;
import com.cg.gops.service.ProductService;
import com.cg.gops.service.ProductServiceImpl;
import com.cg.gops.util.ProductConstants;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductController {

	 @Autowired
	  private ProductServiceImpl productService;
	 
	   
	 
		
		@PostMapping(ProductConstants.ADD_PRODUCT_URL)
		public SuccessMessage addProduct(@RequestBody Product product) throws ProductNameAlreadyExistException{
			return new SuccessMessage(productService.saveProduct(product));
		}
		
		
		@DeleteMapping(ProductConstants.DELETE_PRODUCT_URL)
		public SuccessMessage removeProduct(@PathVariable(value = "productId") String productId) throws ProductNotFoundException {

			return new SuccessMessage(productService.removeProduct(productId));
		}
		
		@GetMapping(ProductConstants.VIEW_ALL_PRODUCT_URL)
		public List<Product> getAllProducts(String productId) {

			return productService.getAllProducts(productId);

		}
		
		@GetMapping(ProductConstants.VIEW_PRODUCT_BY_PRODUCTID_URL)
		public ResponseEntity<Product> getProduct(@PathVariable String productId)throws ProductNotFoundException
		{
			return productService.getProductById(productId);
		}
		
		
		@PostMapping("/editProduct") 
		public String editProduct(@RequestBody Product product) {
			String status = "product updated";
			if(productService.editProduct(product)) {
				return status;
			}
			return "fail to update product!";
			
		}
		
}