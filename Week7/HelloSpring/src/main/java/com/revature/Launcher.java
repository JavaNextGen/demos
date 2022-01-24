package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.config.Config;
import com.revature.models.Account;
import com.revature.models.User;

public class Launcher {

	public static void main(String[] args) {
		
		//create an ApplicationContext type Spring Container 
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//we are instantiating a new ApplicationContext to hold our Spring Beans. 
		//We give it the applicationContext.xml file, so it know how to configure our beans
		
		//This is how you make ApplicationContexts if using a Configuration Class
		//ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		
		//Now that we have a Spring Container ^^^ which stores User and Account beans, we can make some!
		
		//A cast is required because the ApplicationContext can't guess what kind of object will be returned
		User u = (User)ac.getBean("user");
		
		//Let's take a look at what our User bean looks like
		System.out.println(u);
		//we got a User object that the ApplicationContext created for us with .getBean()
		//BUT... nowhere did I create an Account object to attach to it!
			//This is the power of autowiring!
		
		//now we can give our bean some values
		u.setId(1);
		u.setName("coolUser");
		u.getAccount().setBalance(5000.75); //we need to use the getter of the User Class to access the Account fields
		u.getAccount().setType("Checking");
		
		//User should have full data now!
		System.out.println(u);
		
		System.out.println("=====================================================(Messing with Bean Scopes)");
		
		//recall bean scopes - Beans are singletons by default
		User u2 = (User)ac.getBean("user");
		
		//Give some values to the New User
		u2.setId(2);
		u2.setName("coolerUser");
		
		//Thus, this new User object is the same User object as the previous one. Same with the Account object in it.
		System.out.println(u2);
		
		System.out.println(u); 
		
		//We made our User bean prototype scoped (Check the top of the User Class)
		//BUT NOTICE the Account object associated both Users is the same one. 
			//Account is still singleton scoped! We never changed it off the default
		
	}

}
