package com.revature.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Avenger;
import com.revature.repositories.AvengerDAO;

@Controller //Make the class a Bean, but in MVC it lets us use all of the MVC functionality/annotations as well
@ResponseBody //Adds the @ResponseBody annotation to every method in the class. Converts responses to JSON for us.
@RequestMapping(value="/avenger") //all requests ending in /mvc/avenger will go to this Controller
@CrossOrigin //This will let us take in requests from anywhere (or in other words across origins)
public class AvengerController {

	//skipping Service layer for this demo (since the only thing different is the Controllers)
	private AvengerDAO aDAO;
	
	//We want a constructor with only the AvengerDAO so we can use constructor injection and use the DAO methods
	@Autowired //with this annotation, we are using constructor injection, to inject AvengerDAO as a dependency
	public AvengerController(AvengerDAO dao) {
		this.aDAO = dao;
	}
	
	//Declaring some methods that can handle HTTP requests (no more javalin, no more main method code)
	
	//get all Avengers
	@RequestMapping(method=RequestMethod.GET) //Ensures any GET request to /avenger (which is specified above) goes here
	public List<Avenger> assemble(){
		return Arrays.asList(aDAO.getAll());
	}
	
	
	
	
}
