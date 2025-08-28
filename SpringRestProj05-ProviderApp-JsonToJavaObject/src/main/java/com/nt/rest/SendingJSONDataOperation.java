package com.nt.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Customer;
import com.nt.model.Student;

@RestController
@RequestMapping("/json-api")
public class SendingJSONDataOperation {

	@GetMapping("/customer")
	public ResponseEntity<String> ShowCostomerData(){
		System.out.println("SendingJSONDataOperation.ShowCostomerData()");
		Customer c=new Customer(101, "Param", "HYD", 95000.00);
		return new ResponseEntity<String>(c.toString(),HttpStatus.OK);
	}
	
	@GetMapping("allCustomer")
	public ResponseEntity<List<Customer>> showAllCustomer(){
		//Customer c1=new Customer(102,"Sundar","Nanded",4545.55);
		System.out.println("SendingJSONDataOperation.showAllCustomer()");
		Customer c1 = new Customer(101, "Amit", "Pune", 2500.75);
		Customer c2 = new Customer(102, "Sundar", "Nanded", 4545.55);
		Customer c3 = new Customer(103, "Priya", "Mumbai", 3890.40);
		Customer c4 = new Customer(104, "Ravi", "Hyderabad", 5120.90);
		Customer c5 = new Customer(105, "Neha", "Delhi", 2750.00);
		Customer c6 = new Customer(106, "Kiran", "Chennai", 6235.25);
		Customer c7 = new Customer(107, "Rahul", "Nagpur", 3410.85);
		Customer c8 = new Customer(108, "Anita", "Bangalore", 7299.99);
		Customer c9 = new Customer(109, "Vikram", "Aurangabad", 4800.10);
		Customer c10 = new Customer(110, "Sneha", "Kolhapur", 5599.75);
		List list=List.of(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10);
		return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/student")
	public ResponseEntity<Student> showStudentInfo(){
		System.out.println("SendingJSONDataOperation.showStudentInfo()");
		List nickNames=List.of("Ganu","Ganya","Gana");
		String subject[]= {"Java","SpringBoot","RestAPI"};
		Set<String> gNames=Set.of("ABC","DEF","GHE");
		Map<String, Integer> sMarks=new HashMap<String, Integer>();
		sMarks.put("Java", 90);sMarks.put("SpringBoot", 95);sMarks.put("RestAPI", 100);
		Student s=new Student(101,"Ganesh",nickNames,subject,gNames,sMarks);
		return new ResponseEntity<Student>(s,HttpStatus.OK);
	}
}
