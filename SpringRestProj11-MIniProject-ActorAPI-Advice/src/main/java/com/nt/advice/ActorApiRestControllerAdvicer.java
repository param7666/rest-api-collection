package com.nt.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ActorApiRestControllerAdvicer {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handelIAE(IllegalArgumentException xe) {
		System.out.println("ActorApiRestControllerAdvicer.handelIAE()");
		return new ResponseEntity<String>("Problem:: "+xe.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handelAllException(Exception e) {
		System.out.println("ActorApiRestControllerAdvicer.handelAllException()");
		return new ResponseEntity<String>("Problem:: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
