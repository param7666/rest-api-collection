package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest-api")
public class RequestParamController {

//	@GetMapping("/report")
//	public ResponseEntity<String> showReport(@RequestParam("id") int id,@RequestParam("name")String name) {
//		System.out.println("RequestParamController.showReport()");
//		System.out.println("Request Param values :: id="+id+" Name="+name);
//		return new ResponseEntity<String>("req params are ::"+ id+"...."+name, HttpStatus.OK);
//	}
	
//	@GetMapping("/report")
//	public ResponseEntity<String> showReport(@RequestParam int id,@RequestParam String name) {
//		System.out.println("RequestParamController.showReport()");
//		System.out.println("Request Param values :: id="+id+" Name="+name);
//		return new ResponseEntity<String>("req params are ::"+ id+"...."+name, HttpStatus.OK);
//	}
	
	
	@GetMapping("/report")
	public ResponseEntity<String> showReport(@RequestParam int id,@RequestParam(required = false) String name) {
		System.out.println("RequestParamController.showReport()");
		System.out.println("Request Param values :: id="+id+" Name="+name);
		return new ResponseEntity<String>("req params are ::"+ id+"...."+name, HttpStatus.OK);
	}
	
//	@GetMapping("/report")
//	public ResponseEntity<String> showReport(@RequestParam int id,@RequestParam(required = false, defaultValue = "Param") String name) {
//		System.out.println("RequestParamController.showReport()");
//		System.out.println("Request Param values :: id="+id+" Name="+name);
//		return new ResponseEntity<String>("req params are ::"+ id+"...."+name, HttpStatus.OK);
//	}
}
