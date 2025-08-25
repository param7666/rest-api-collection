package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/wish-api")
@RestController
public class WishMessage {

	@GetMapping("/wish")
	public ResponseEntity<String> showMessage(){
		String msg="Hey i am From showMessage";
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	
}
