package com.revature;

import com.revature.models.Associate;
import com.revature.models.Person;

public class Launcher {

	public static void main(String[] args) {
		
		//keyboard shortcut for imports: ctrl+shift+o
		Associate patrick = new Associate("Patrick", "Hazel", "211206");
		
		//concrete method from Person
		patrick.die(); //RIP
		
		//Overridden method from the Walkable Interface
		patrick.move(0);
		
		//Overidden method from the Person Abstract Class
		System.out.println(patrick.talk("uhhhhhhh and he tries real hard"));
		
		patrick.trip(); //concrete method from the Interface
		
		
		//ben digs himself out of the upcasting hole---------------------------------
		Person daniel = new Associate("Daniel", "Brown", "211206");
		//upcasting - parent type reference variable, child type object
		//now, we can't access the Assocaite-specific members, except for overridden methods
		
		//System.out.println(daniel.batch); //batch is an Associate-specific method
		
		daniel.move(50); //this is a member of the Person class - so it's still visible

		daniel.talk(" making real progress on my project"); //this is visible, because it's an overridden method
		
	}

}
