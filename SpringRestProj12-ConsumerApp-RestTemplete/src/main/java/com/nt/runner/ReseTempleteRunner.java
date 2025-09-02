package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ReseTempleteRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// create rest templte object
		RestTemplate template=new RestTemplate();
		// define url
		String ServiceUrl="http://localhost:8082/restApp/name-api/print";
		// generate the HTTPRequest with get mode to consume the webservice
		ResponseEntity<String> response=template.getForEntity(ServiceUrl, String.class);
		// display the recived details form response
		System.out.println("Response body (output):: "+response.getBody());
		//System.out.println("Response HTTP status code:: "+response.getStatusCodeValue());
		System.out.println("Response https status code:: "+response.getStatusCode());
		
		System.out.println("ReseTempleteRunner.run()");
		System.out.println("Application run and exit..........");
		
	}

}
