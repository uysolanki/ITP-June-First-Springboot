package com.itp.ITPJuneFirstSpringboot.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.itp.ITPJuneFirstSpringboot.response.ErrorResponse;
import com.itp.ITPJuneFirstSpringboot.response.ValidationError;

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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ValidationError>> handleValidationExceptions(MethodArgumentNotValidException ex) {
			 List<ValidationError> errors = new ArrayList<>();
			 for (Object error :  ex.getBindingResult().getAllErrors()) 
				{
				 	FieldError err =(FieldError)error;
					ValidationError err1 = new ValidationError(err.getDefaultMessage(),err.getField(), err.getRejectedValue());
			        errors.add(err1);
			    }

			 return new ResponseEntity<List<ValidationError>>(errors,HttpStatus.BAD_REQUEST);
		}
    }
	
	

