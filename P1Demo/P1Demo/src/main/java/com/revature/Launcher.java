package com.revature;

import com.revature.models.Menu;

public class Launcher {

	public static void main(String[] args) {
		
		//Testing Database Connectivity
		
		
		//Here is the actual functionality of our application-------------------
		
		//spoiler alert... there will only be two lines of codes here
		
		
		//Instantiate a menu object
		Menu menu = new Menu();
		
		//Use the Menu Class's displayMenu() method to give the user the menu
		menu.displayMenu();
		
		
		//this is our entire main method (until we learn Javalin in week 4)
		
		//all of the complicated menu logic is hidden in the Menu class... this is power of abstraction!!!!!
		
	}

}
