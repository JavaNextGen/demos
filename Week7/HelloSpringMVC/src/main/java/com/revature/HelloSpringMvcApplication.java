package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringMvcApplication.class, args);
		
		java.sql.Date date = java.sql.Date.valueOf("2022-05-01");
		
		System.out.println(date);
		
	}

}
