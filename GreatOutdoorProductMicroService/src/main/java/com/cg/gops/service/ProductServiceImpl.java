package com.cg.gops.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.gops.dao.ProductRepository;
import com.cg.gops.entity.Product;
import com.cg.gops.exception.ProductNameAlreadyExistException;
import com.cg.gops.exception.ProductNotFoundException;
import com.cg.gops.util.ProductConstants;

@Service
public class ProductServiceImpl implements  ProductService{

	@Autowired
	ProductRepository repository;
	

	/******************************************************************************************
	-Function Name            :     saveProduct
	-Description              :     adding Product to the Product Database Table using Spring Data
	-Input Parameters         :     Product Object
	-Return Type              :     added Product object
	-Throws                   :     ProductNameAlreadyExistException();
	-Author                   :     DIVYA
	-Created/Modified Date    :     20-09-20
	*******************************************************************************************/
	
	@Override
	public String saveProduct(Product product)throws ProductNameAlreadyExistException {
		Optional<Product> findId=repository.findById(product.getProductId());
		if(findId.isPresent()) {
			throw new ProductNameAlreadyExistException(ProductConstants.PRODUCT_NAME_ALREADY_EXIST);
		}
		/*if(centerRepo.getByCenterName(diagnosticCenter.getCenterName())!=null) {
			throw new NameAlreadyExistException(TestConstants.NAME_ALREADY_EXIST);
		}*/
		repository.save(product);
		return ProductConstants.PRODUCT_ADDED;
		
	}
	
	/********************************************************************************************
	-Function Name            :     removeProduct
	-Description              :     delete Product from the Product Database Table
	-Input Parameters         :     Product Id
	-Return Type              :     String showing whether deleted or not
	-Throws                   :     ProductNotFoundException();
	-Author                   :     DIVYA
	-Created/Modified Date    :     20-09-2020
	*******************************************************************************************/
	
	@Override
	public String removeProduct(String productId) throws ProductNotFoundException
    {
	 Optional<Product> findById = repository.findById(productId);
		if (findById.isPresent()) {
			repository.deleteById(productId);
			return ProductConstants.PRODUCT_DELETED;
		} else {
			return ProductConstants.PRODUCT_NOT_FOUND;
		}
    }
	

	/******************************************************************************************
	-Function Name            :     getAllProducts
	-Description              :     getting all Products from the Product Database Table using Spring Data
	-Input Parameters         :     Product Id only
	-Return Type              :     Product object corresponding to the given Id
	-Author                   :     DIVYA
	-Created/Modified Date    :     20-09-2020
	*********************************************************************************************/
	
	@Override
	public List<Product> getAllProducts(String productId){
    	return repository.findAll();   	
    }
 
	
	/******************************************************************************************
	-Function Name            :     getProductById
	-Description              :     getting Product from the Product Database Table using Spring Data
	-Input Parameters         :     Product Id only
	-Return Type              :     Product object corresponding to the given Id
	-Throws                   :     ProductNotFoundException();
	-Author                   :     DIVYA
	-Created/Modified Date    :     20-09-2020
	*********************************************************************************************/
	
	
	@Override
	public ResponseEntity<Product> getProductById(String productId) throws ProductNotFoundException {
		Product product=repository.findById(productId).
			   	 orElseThrow(() -> new ProductNotFoundException(ProductConstants.PRODUCT_NOT_FOUND));
			    	return ResponseEntity.ok().body(product);
	}	
	
	
	/******************************************************************************************
	-Function Name            :     editProduct
	-Description              :     updating Product in the Product Database Table using Spring Data
	-Input Parameters         :     Product Object
	-Return Type              :     updated Product object
	-Throws                   :     ProductNameAlreadyExistException();
	-Author                   :     Prashant Kumar Upadhyay
	-Created/Modified Date    :     21-09-20
	*******************************************************************************************/
	
	@Override
	public boolean editProduct(Product product) {
		
		Optional<Product> find = repository.findById(product.getProductId());
		if(find.isPresent()) {
			repository.save(product);
			return true;
		}
		 
		return false;
	}
	
}
