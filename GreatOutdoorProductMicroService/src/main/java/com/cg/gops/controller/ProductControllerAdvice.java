package com.cg.gops.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;

import com.cg.gops.dto.ErrorMessage;
import com.cg.gops.exception.*;

@RestController
@RestControllerAdvice
public class ProductControllerAdvice {


	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ProductNameAlreadyExistException.class)
	public ErrorMessage handleProductNameAlreadyExistException(ProductNameAlreadyExistException ex)
	{
	 return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), ex.getMessage(), LocalDateTime.now().toString());
	       //To Handle ProductName Already Exist Exception	
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(ProductNotFoundException.class)
	public ErrorMessage handleProductNotFoundException(ProductNotFoundException ex)
	{
	  return new ErrorMessage(HttpStatus.NOT_FOUND.toString(), ex.getMessage(), LocalDateTime.now().toString());
		
	}
	
}
	
	