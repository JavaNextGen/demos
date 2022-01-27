package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Pokemon;

//By extending JpaRepository, we get access to various DAO methods that we don't have to write ourselves
//JpaRepository takes two generics... (Pokemon and Integer in our case)
	//The first generic is the entity being persisted
	//The second generic is the data type of the primary key (as a wrapper class)
@Repository
public interface PokemonDAO extends JpaRepository<Pokemon, Integer> {

	
	
}
