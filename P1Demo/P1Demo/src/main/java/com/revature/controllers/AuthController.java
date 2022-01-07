package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;

import io.javalin.http.Handler;

public class AuthController {

	public Handler loginHandler = (ctx) -> {
		
		//what's the request body? (which we get from ctx.body) it's the data that gets sent in with a request
		//GET requests will have empty request bodies, but POST requests, which send data, will have some data.
		String body = ctx.body(); //turn the body (data) of the POST request into a Java String
		
		Gson gson = new Gson(); //create a new Gson object to make Java <-> JSON conversions
		
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class); //turn that JSON String into a LoginDTO object
		
		
		//control flow to determine what happens in the event of successful/unsuccessful login
		//if()
		
	};

}
