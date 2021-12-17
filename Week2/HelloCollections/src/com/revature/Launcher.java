package com.revature;

import java.util.ArrayList;

import com.revature.models.Pokemon;

//Collections are like Arrays in that they are objects that hold data
//but specifically, they hold references to other objects (because collections can only hold objects)
//so if we need to use int types, we actually need to use their wrapper classes E.g. int -> Integer

//unlike Arrays, collections can change size DYNAMICALLY (so they can grow and shrink)

public class Launcher {

	public static void main(String[] args) {
			
		System.out.println("=========================================(Lists)");
		
		//ArrayList is a very common implementation of the List Interface
		//QC asked me the difference between Array and ArraysLists when I was an associate
		
		//This is an ArrayList of Pokemon objects
		ArrayList<Pokemon> myPokemonList = new ArrayList<>(); //instantiated an empty ArrayList
		
		//.add() method can add elements to your Collections
		myPokemonList.add(new Pokemon("Pikachu", "Electric"));
		myPokemonList.add(new Pokemon("Mudkip", "Water"));
		myPokemonList.add(new Pokemon("Bulbasaur", "Grass/Poison"));
		myPokemonList.add(new Pokemon("Eevee", "Normal"));
		myPokemonList.add(new Pokemon("MissingNo", "Flying/Normal"));
		
		//we can print out myPokemonList
		//System.out.println(myPokemonList); //print statements implicitly call the toString() method if it's present
		
		//BUT it'll be cleaner to use an enhanced for loop to iterate over the data structure
		for(Pokemon p : myPokemonList) {
			System.out.println(p);
		}
		
		//.add(index) at specific indeces
		myPokemonList.add(4, new Pokemon("Vaporeon", "Water"));
		
		//.get(index) is how we select elements of a certain index
		//NOTE: because of zero-indexing Vaporeon is at index 4, but it's technically the 5th element
		System.out.println("The Pokemon at index 4 is: " + myPokemonList.get(4).getName());
		//.get() got the Pokemon object, and .getName() returns the name field of that Pokemon
		
		//.size() is analogous to .length in Arrays - simply returns the number of elements
		System.out.println("I have " + myPokemonList.size() + " Pokemon in my party");
		
		
		
		
//		System.out.println("=========================================(Sets)");
//		
//		
//		
//		
//		
//		System.out.println("=========================================(Queues)");
//		
//		
//		
//	
//		
//		System.out.println("=========================================(Maps)");
//		
		
	}
	
}
