package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Pokemon;
import com.revature.repositories.PokemonDAO;

@RestController //This annotation combines @Controller and @ResponseBody. 
	//So this class is now a Bean that can use MVC annotations and sends responses back in JSON format\
@RequestMapping(value="/pokemon") //any request ending in /pokemon will go to this controller
public class PokemonController {

	//I just need to autowire the DAO class to this class
	//Like in the last MVC demo, I'm skipping the service layer just for time, but you should still use services
	private PokemonDAO pDAO;
	
	//so now, PokemonController will automagically have a PokemonDAO associated with it
	@Autowired
	public PokemonController(PokemonDAO pDAO) {
		this.pDAO = pDAO;
	}
	
	
	//MVC methods below (to handle HTTP requests)------------------------------
	
	//These SHOULD probably call a service layer that's calling the DAO
		//so .body() would contain a call to the service method that gets the appropriate data from the DAO

	@PostMapping //every POST request ending in /pokemon goes here
	public ResponseEntity addPokemon(@RequestBody Pokemon p) {
		System.out.println("Hi, we're in the controller");
		
		pDAO.save(p); //the save() method is how we do INSERTS
		return ResponseEntity.status(201).build();
		//we use .build() instead of .body() if we don't intend to send data back.
	}
	
	
}
