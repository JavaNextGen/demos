package com.revature.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //we'll learn this in the next demo, but @Controller gives extra functionality with Spring Web
//It also lets us handle HTTP Requests! There are lots more annotations that go into it that we'll see soon
public class HelloController {

	@GetMapping("/hello") //any HTTP GET requests ending in /hello will go to this method to get a response
	public ResponseEntity<String> hello(){
		return ResponseEntity.status(200).body("Hello Spring Boot! That was easy :)");
	}
	
}
