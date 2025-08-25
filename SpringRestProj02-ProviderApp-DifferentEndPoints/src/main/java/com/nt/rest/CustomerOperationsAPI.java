package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsAPI {

	@GetMapping("/show")
	public ResponseEntity<String> showCustomerData() {
		System.out.println("CustomerOperationsAPI.showCustomerData()");
		return new ResponseEntity<String>("Showing single user data...", HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(){
		System.out.println("CustomerOperationsAPI.registerCustomer()");
		return new ResponseEntity<String>("Customer registration complete..",HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateCustomer(){
		System.out.println("CustomerOperationsAPI.UpdateCustomer()");
		return new ResponseEntity<String>("Customer Details updated Successfully..",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCustomer(){
		System.out.println("CustomerOperationsAPI.deleteCustomer()");
		return new ResponseEntity<String>("Customer deleted successfully..",HttpStatus.OK);
	}
	
	@PatchMapping("emailUpdate")
	public ResponseEntity<String> updateCustomerEmail(){
		System.out.println("CustomerOperationsAPI.updateCustomerEmail()");
		return new ResponseEntity<String>("Customer Email updated..",HttpStatus.OK);
	}
	
	@GetMapping("all")
	public ResponseEntity<String> showAllCustomer() {
		System.out.println("CustomerOperationsAPI.showAllCustomer()");
		return new ResponseEntity<String>("Showing All Customer data..",HttpStatus.OK);
	}
}
