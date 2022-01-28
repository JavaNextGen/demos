package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Pokemon;

//By extending JpaRepository, we get access to various DAO methods that we don't have to write ourselves
//JpaRepository takes two generics... (Pokemon and Integer in our case)
	//The first generic is the entity being persisted
	//The second generic is the data type of the primary key (as a wrapper class)
@Repository
public interface PokemonDAO extends JpaRepository<Pokemon, Integer> {

	//we have to define this method signature on our own, because it's more complicated than JpaRepository can provide
		//JpaRepository can't find by non-Id fields
	//BUT Spring Data will create this method body for us, we just have to provide the abstract method
	public Optional<List<Pokemon>> findByName(String name);
	
	//NOTE* Spring wants your method names to be in camelCase, or it will throw a vague error (cannot create bean etc.)
	
	//an Optional is an object that MAY have whatever the generic is, or it may be null. Avoids NullPointerExceptions
	
	
}
