package com.nt.rest;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Customer;
import com.nt.model.Student;

@RestController
@RequestMapping("/json-api")
public class SendingJSONDataOperation {

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody Customer c) {
		System.out.println("Customer Object Data:: "+c);
		return new ResponseEntity<String>(c.toString(),HttpStatus.OK);
	}
	
	@PostMapping("/register-student")
	public ResponseEntity<String> registerStudent(@RequestBody Student s) {
		System.out.println("SendingJSONDataOperation.registerStudent()");
		System.out.println("Student Object Data:: "+s);
		return new ResponseEntity<String>(s.toString(),HttpStatus.OK);
	}
	
	@PostMapping("/register-student-list")
	public ResponseEntity<String> registerStudent(@RequestBody List<Student> s) {
		System.out.println("SendingJSONDataOperation.registerStudent()");
		System.out.println("Student Object Data:: "+s);
		return new ResponseEntity<String>(s.toString(),HttpStatus.OK);
	}
	
}
