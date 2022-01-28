package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.models.Pokemon;
import com.revature.repositories.PokemonDAO;

@RestController //This annotation combines @Controller and @ResponseBody. 
	//So this class is now a Bean that can use MVC annotations and sends responses back in JSON format\
@RequestMapping(value="/pokemon") //any request ending in /pokemon will go to this controller
public class PokemonController {

	//I just need to autowire the DAO class to this class
	//Like in the last MVC demo, I'm skipping the service layer just for time, but you should still use services
	private PokemonDAO pDAO;
	
	private RestTemplate restTemplate = new RestTemplate(); //RestTemplate object to send HTTP requests... from Java wow!
	//With RestTemplate, we can send and receive JSON from our Java.
	
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
	
	@GetMapping
	public ResponseEntity<List<Pokemon>> getAllPokemon(){
		
		return ResponseEntity.status(200).body(pDAO.findAll());
		
		//return ResponseEntity.ok(pDAO.findAll()); //This would also work!! .ok() sets status code to 200
		
	}
	
	@GetMapping(value = "/id/{id}") //the number given as a URL endpoint will be the parameter in this method, hence @PathVariable
	public ResponseEntity<Pokemon> findById(@PathVariable int id){
		Pokemon p = pDAO.findById(id).get();
		return ResponseEntity.ok(p);
	}
	
	//getById() is deprecated!! Don't ask questions, findById is the truth.
	

	//This method will call the custom DAO method we created
	@GetMapping(value = "/name/{name}")
	public ResponseEntity<List<Pokemon>> findByName(@PathVariable String name){
		
		//Remember - an Optional may or may not have the generic, or it may be null
		Optional<List<Pokemon>> pokemon = pDAO.findByName(name);
		
		List<Pokemon> pokeList = null; //empty List to potentially be populated 
		
		if(pokemon.isPresent()) { //if the Optional has content...
			pokeList = pokemon.get(); //this is how you get the contents of an Optional
			return ResponseEntity.ok(pokeList);
		} else {
			return ResponseEntity.noContent().build(); //else return nothing but a no content code
		}
	}
	
	//using RestTemplate 
	@GetMapping(value = "/find/{name}")
	public ResponseEntity<Pokemon> getPokemonFromApi(@PathVariable String name){
		
		//getForObject() well send a GET request to the specified URL, for a specified object type
		//So here, we're sending a GET request to the pokeapi, to get a certain pokemon
		Pokemon externalPoke = this.restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/"+name, Pokemon.class);
		
		if(externalPoke == null) {
			return ResponseEntity.noContent().build(); //send nothing back if our Pokemon is null
		}
		
		return ResponseEntity.ok(externalPoke);
		
	}
	
}
