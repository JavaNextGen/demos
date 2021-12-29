package com.revature;

import java.util.List;

import com.google.gson.Gson;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {
		
		// Always build the Javalin Object to app, this most common & best practice!!!!!
		// Starting on port 3000 on localhost as well. Though you can use an available port
		// localhost:3000/ is the default endpoint
		Javalin app = Javalin.create().start(3000);
		
		app.get("/", ctx -> {
			
			ctx.result("Hello you've successfully set up Javalin!! Hoo Rah!");
			ctx.status(200);
			
		});
		
		// return whatever you enter in after localhost:3000/hi/bungee
		app.get("/hi/{name}", ctx -> {
			ctx.result("Hi winner " + ctx.pathParam("name"));
			ctx.status(200);
		});
		
		// Includes all of the following '/' something like /hello/john/mary/joe
		// get in your params john/mary/joe
		
		app.get("/hello/<name>", ctx ->{
			ctx.result("Hello " + ctx.pathParam("name"));
			ctx.status(200);
		});
		
		// return whatever you enter in after localhost:3000/hi/bungee
		app.get("/employee/{e_id}", ctx -> {
//				ctx.result(1 + Integer.parseInt(ctx.pathParam("e_id")));
				ctx.status(200);
			});
		
		// return whatever you enter in after localhost:3000/hi/bungee
				app.get("/hi/{name}/{age}", ctx -> {
					ctx.result("Hi winner " + ctx.pathParam("name") + " " + ctx.pathParam("age"));
					ctx.status(200);
				});
		
		// Avoid the below by hitting the red terminate button(red square) at the bottom right!!!!
		// Try to always look for this button, if white program is not running and you are good to run!
		// IF red, click it before running your program
		
		// Did you forget to do above? Oh no, that's fine follow the steps below!
		// OOPS you locked your port!!!! What to do now? 
		// Easy(lazy try not to do this) option: just change the port number uup in line 12
		// 		eats up the memory
		// True solution through cmd prompt:
		// windows key(press the startmenu) type in cmd
		// netstat -ano 
			// look for the port that is being used
			// find it's PID (process identifier) should be the last column
			// BE SURE TO SELECT THE APPROPRIATE PID!!!!!!!!!!
		// to kill a process that is takin up your port
		// taskkill /PID insert_your_PID_number_here /F
		// ie. taskkill /PID 3292 /F
		// PLEASE PLEASE make sure your using the right PID


	}

}
