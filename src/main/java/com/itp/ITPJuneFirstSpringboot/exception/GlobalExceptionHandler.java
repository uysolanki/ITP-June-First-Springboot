package com.itp.ITPJuneFirstSpringboot.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.itp.ITPJuneFirstSpringboot.response.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(ProductNotFoundException.class)
//	public ResponseEntity<String> handleProductNotFound(ProductNotFoundException ex)
//	{
//			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
//	}
	
//	@ExceptionHandler(ProductNotFoundException.class)
//	public ResponseEntity<Map<String,Object>> handleProductNotFound(ProductNotFoundException ex)
//	{
//		Map<String,Object> error=new HashMap<String, Object>();
//		error.put("errorType", "Product Not Found");
//		error.put("error Message", ex.getMessage());
//		error.put("error timestamp", LocalDateTime.now());
//		
//		return new ResponseEntity<Map<String,Object>>(error,HttpStatus.BAD_REQUEST);
//	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleProductNotFound(ProductNotFoundException ex)
	{
		ErrorResponse error=new ErrorResponse("Product Not Found",ex.getMessage(),LocalDateTime.now(),HttpStatus.BAD_REQUEST.value());		
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
	
	

}
