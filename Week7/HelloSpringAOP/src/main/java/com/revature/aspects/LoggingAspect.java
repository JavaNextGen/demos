package com.revature.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//This Class is where we will handle all of our logging functionality (A Cross Cutting Concern)
//SO much cleaner to put all of our logging logic in one specific place instead of all over the application
@Component //make the class a bean
@Aspect //let Spring know that this class is an ASPECT. It handles SpringAOP Cross Cutting Concerns
public class LoggingAspect {

	//Instantitate a Logger object
	private static Logger log = LogManager.getLogger(LoggingAspect.class);
	
	//let's write some advices-----------------------
	//remember, advices are just the pieces of code (usually methods) that we'll inject into JoinPOints
	
	//This advice will run BEFORE any method in any Class in the models package (note the *)
	@Before("within(com.revature.models.*)")
	public void logModelClassMethods(JoinPoint jp) { //a JoinPoint is somewhere an advice COULD be injected, models in this case
		log.info(jp.getTarget() + " invoked " + jp.getSignature());
		//getTarget() returns the object getting called, and configures our JoinPoint to our specific PointCut
		//getSignature() gets the method signature as a String
	}
	
}
