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
		
		
		

	}

}
