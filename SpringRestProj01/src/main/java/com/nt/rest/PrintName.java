package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/name-api")
@RestController
public class PrintName {

	@GetMapping("/print")
	public ResponseEntity<String> showName(){
		return new ResponseEntity<String>("Param",HttpStatus.OK);
	}
}
