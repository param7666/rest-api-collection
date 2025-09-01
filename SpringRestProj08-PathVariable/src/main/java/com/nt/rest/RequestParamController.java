package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest-api")
public class RequestParamController {

//	@GetMapping("/report/{id}/{name}/{adrs}")
//	public ResponseEntity<String> showReport(@PathVariable int id,@PathVariable String name, @PathVariable String adrs) {
//		System.out.println("RequestParamController.showReport()");
//		System.out.println("Request Param values :: id="+id+" Name="+name+" addrs="+adrs);
//		return new ResponseEntity<String>("req params are ::"+ id+"...."+name+"...."+adrs, HttpStatus.OK);
//	}

//	@GetMapping(value = {"/report/{id}/{name}/{adrs}","/report/{id}/{name}","/report/{id}","/report"})
//	public ResponseEntity<String> showReport(@PathVariable(required = false) Integer id,@PathVariable(required = false) String name, @PathVariable(required = false) String adrs) {
//		System.out.println("RequestParamController.showReport()");
//		System.out.println("Request Param values :: id="+id+" Name="+name+" addrs="+adrs);
//		return new ResponseEntity<String>("req params are ::"+ id+"...."+name+"...."+adrs, HttpStatus.OK);
//	}
	
	@GetMapping("/report/id/name")
	public ResponseEntity<String> fetchData1(@PathVariable(name = "id",required = false) Integer id,
												@PathVariable(name="name", required = false) String name) {
		System.out.println("RequestParamController.fetchData1()");
		return new ResponseEntity<String>("fetchData1",HttpStatus.OK);
	}
	
	@GetMapping("/report/id/{name}")
	public ResponseEntity<String> fetchData2(@PathVariable(name = "id",required = false) Integer id,
												@PathVariable(name="name", required = false) String name) {
		System.out.println("RequestParamController.fetchData2()");
		return new ResponseEntity<String>("fetchData2",HttpStatus.OK);
	}
	
	@GetMapping("/report/{id}/name")
	public ResponseEntity<String> fetchData3(@PathVariable(name = "id",required = false) Integer id,
												@PathVariable(name="name", required = false) String name) {
		System.out.println("RequestParamController.fetchData3()");
		return new ResponseEntity<String>("fetchData3",HttpStatus.OK);
	}
	
	@GetMapping("/report/{id}/{name}")
	public ResponseEntity<String> fetchData4(@PathVariable(name = "id",required = false) Integer id,
												@PathVariable(name="name", required = false) String name) {
		System.out.println("RequestParamController.fetchData4()");
		return new ResponseEntity<String>("fetchData4",HttpStatus.OK);
	}
	
	
	

}
