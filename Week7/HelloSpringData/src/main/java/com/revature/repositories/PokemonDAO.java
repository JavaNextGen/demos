package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Pokemon;

//Ben will explain this LEAVING COMMENT HERE TO REMEBER TO COMMENT AFTER BREAK
public interface PokemonDAO extends JpaRepository<Pokemon, Integer> {


	
}
