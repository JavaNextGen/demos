package com.revature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

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
		//"Insert this new Pokemon at index 4", this bumps the elements after it to the index above it.
		
		//.get(index) is how we select elements of a certain index
		//NOTE: because of zero-indexing Vaporeon is at index 4, but it's technically the 5th element
		System.out.println("The Pokemon at index 4 is: " + myPokemonList.get(4).getName());
		//.get() got the Pokemon object, and .getName() returns the name field of that Pokemon
		
		//.size() is analogous to .length in Arrays - simply returns the number of elements
		System.out.println("I have " + myPokemonList.size() + " Pokemon in my party");
		
		//we're going the use a forEach with a lambda to make the Pokemon "fight"
		//the forEach method will loop through a Collection and perform a given action
		myPokemonList.forEach(pokemon -> pokemon.fight());
		//in other words it does this FOR EACH element in the ArrayList
		
		//.remove() will remove a specific element given its index
		myPokemonList.remove(4);
		myPokemonList.remove(2);
		//as we remove these, the elements will 
		
		//use forEach one more time to print out the remaining Pokemon
		myPokemonList.forEach(pokemon -> System.out.println(pokemon.getName()));
		
		//more complicated forEach... nested if statement
		myPokemonList.forEach(pokemon -> {
		
				if(pokemon.getType() == "Water") {
					System.out.println(pokemon.getName() + " is water type");
				}
				
			}
		
			);	
		
		System.out.println("=========================================(Sets)");
		
		HashSet<Pokemon> myPokemonSet = new HashSet<>();
		
		//Let's explore how Sets are Different from Lists------
		
		//making a Pokemon reference variable to show how Sets don't allow duplicates
		Pokemon eevee = new Pokemon("Eevee", "Normal");
		
		myPokemonSet.add(new Pokemon("Charizard", "Fire/Flying"));
		myPokemonSet.add(new Pokemon("Mudkip", "Water"));
		myPokemonSet.add(eevee);
		myPokemonSet.add(eevee); //Java will let you attempt to add a duplicate... but....
		myPokemonSet.add(new Pokemon("MissingNo", "Flying/Normal"));
		myPokemonSet.add(new Pokemon("Bulbasaur", "Grass/Poison"));
		
		//Notice how Sets are not in any particular order like Lists are!! 
		//Also note how there are no duplicates allowed
		for(Pokemon p : myPokemonSet) {
			System.out.println(p);
		}
		
		//rememeber, Sets have no order... and they have no index
		//So what happens if we try to use .get() on a Set?
		
		//myPokemonSet.get(4); //Nothing happens... Sets don't have .get() functionality
		
		//One way to see if specific objects exist in the Set is to use .contains()
		if(myPokemonSet.contains(eevee)) {
			System.out.println("Eevee do be in there thoooooo");
		}
		
		//Sets have no index... but if we use .iterator() we can create an Iterator from that set
		Iterator<Pokemon> it = myPokemonSet.iterator();
		
		//while there are element left in this iterator, print the next element
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//the while loop breaks once there are no more values
		
		
		System.out.println("=========================================(Queues)");
		
		LinkedList<Pokemon> pokemonLL = new LinkedList<Pokemon>();
		
		pokemonLL.add(new Pokemon("Charizard", "Fire/Flying"));
		pokemonLL.add(new Pokemon("Mudkip", "Water"));
		pokemonLL.add(1, new Pokemon("Magikarp", "Water")); //adding to a specific index
	
		//iterate through the linkedlist
		for(Pokemon p : pokemonLL) {
			System.out.println(p);
		}
		//note the order - queues have a strict order based on index
		
		//show the name of the first Pokemon using .peek()
		System.out.println(pokemonLL.peek().getName() + " is the first Pokemon in the LinkedList");
		
		//.poll() will get and remove the first element
		System.out.println(pokemonLL.poll().getName() + " is leaving the chat");
		
		//notice that charizard is gone!
		for(Pokemon p : pokemonLL) {
			System.out.println(p);
		}
		
		System.out.println("=========================================(Maps)");
		
		//Instantiate a super simple map before working with Pokemon objects
		
		TreeMap<Integer, String> simpleMap = new TreeMap<>();
		//created a treemap object with an Integer key, and a String value
		//the data types of keys and values can be whatever you want!
		
		//insert values into the map
		simpleMap.put(1, "one");
		simpleMap.put(1, "two"); //duplicate keys will be ignored! the old value gets replaced
		simpleMap.put(3, "two"); //duplicate values are allowed!
		
		System.out.println(simpleMap);
		
	}
	
}
