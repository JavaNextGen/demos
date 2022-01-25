package com.revature.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	//Declaring some methods that can handle HTTP requests (no more javalin, no more main method code)------------------
	
	//get all Avengers
	@RequestMapping(method=RequestMethod.GET) //Ensures any GET request to /avenger (which is specified above) goes here
	public List<Avenger> assemble(){
		return Arrays.asList(aDAO.getAll()); //.getAll() returns an Array... we just have to turn it into a List 
	}
	
	//get Avenger by id
	@GetMapping("/{id}") //GetMapping will specify that GET requests with the /avenger url go here
	//But here, we've added a path parameter. So if a GET request is sent to /avenger/(some number), this method takes it
	//@PathVariable will allow you to get the path variable sent in the with URL (id in this case)
	//Spring has an object called ResponseEntity that lets us set things like status code, and the response body
	public ResponseEntity<Avenger> getOneAvenger(@PathVariable("id") int id){
		
		Avenger a = aDAO.getById(id); //get an Avenger with the id path parameter that gets sent in with the request
		
		//if getById fails...
		if(a == null) {
			//send back an empty body with a "no content" (204) status code
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(a);
		}
		
		//If the "if" doesn't run, send back the Avenger in the body of the response and an OK (200) status code
		return ResponseEntity.ok(a); // <- This is the shorthand for: return ResponseEntity.status(HttpStatus.OK).body(a);
	}
	
	//update avenger
	@PutMapping //any HTTP PUT request ending in /avenger will go here
	//@RequestBody converts JSON from the body of the request into an object we specify. @ResponseBody, but for requests
	public ResponseEntity<Avenger> updateAvenger(@RequestBody Avenger a){
		
		if(a == null) {
			ResponseEntity.status(HttpStatus.NO_CONTENT).body(a);
		}
		
		//if Avenger a is NOT null, use the update DAO method, and set the Avenger a object to the newly updated data
		a = aDAO.update(a);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(a);
		
	}
	
}
