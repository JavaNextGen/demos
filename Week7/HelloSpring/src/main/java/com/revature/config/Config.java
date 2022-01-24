package com.revature.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revature.models.Account;
import com.revature.models.User;

@Configuration //This is how we specify that a Class is a Bean Configuration Class
public class Config {

	//Commented everything out because we won't wire beans this way typically...
	//But you should know the syntax and annotations involved in it
	
//	@Bean(name = "user")
//	public User getUser() {
//		
//		//return new User();
//		//This^^^ return statement won't cut it - we need to WIRE our beans through a constructor with the Account Bean
//		
//		//Since we built a User constructor for just Accounts, we can use the getAccount() method below
//		return new User(getAccount());
//		
//	}
//	
//	@Bean(name = "account")
//	public Account getAccount() {
//		
//		return new Account();
//		
//	}
//	
}
