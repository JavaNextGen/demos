package com.revature;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Launcher {

	public static void main(String[] args) {
		
		boolean displayMenu = true;
		
		//Instantiate a Scanner object
		Scanner scan = new Scanner(System.in);
		
		//Instantiate a Logger object
		Logger log = LogManager.getLogger(Launcher.class);
		
		//Write some code to log in the form of a scanner menu
		
		while(displayMenu) {
			
			System.out.println("HELLO USER------ Please Log In");
			
			log.info("/user accessed login prompt/");
			
			System.out.println("USERNAME:");
			String username = scan.nextLine();
			System.out.println("PASSWORD:");
			String password = scan.nextLine();
			
			if(username.equals("user") && password.equals("password")) {
				log.info("/User successfully logged in/");
				
				System.out.println("What is your favorite animal?");
				String input1 = scan.nextLine();
				
				log.info("/User inputted value of: " + input1 + "/");
				
				System.out.println(input1 + " is a great animal!");
				
				if(input1.equals("Rock")) {
					log.debug("/User is probably not very smart/");
				}
				
				System.out.println("What is your goal in life?");
				String input2 = scan.nextLine();
				
				log.info("/User inputted value of: " + input2 + "/");
				
				if(input2.equals("World Domination")) {
					log.fatal("/You gonna die baby/");
				}
				
				displayMenu = false;
			} else {
				log.warn("/User failed to log in/");
				displayMenu = false;
			}
			
		}
		
		
		log.info("/User Exited Program/");
		
		
	}
	
}
