package com.revature.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.revature.models.Avenger;

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
	
	
	//Remember, a PointCut is where advice WILL be injected. In this case, any method called (fight) that returns a String
	//the "returning" attribute is simply giving us access to the returned object from the method (A String in this case)
	//fight(..) means "any method called fight that takes any number of parameters"
	@AfterReturning(pointcut="execution(String fight(..))", returning = "returnedObject")
	public void logSuccessfulFight(JoinPoint jp, Object returnedObject) {
		log.info(jp.getTarget() + " invoked " + jp.getSignature() + " and returned " + returnedObject);
	}
	
	@AfterThrowing(pointcut="execution(String fight(..))", throwing="thrownException")
	public void logFailedFight(JoinPoint jp, Exception thrownException) {
		log.warn(jp.getTarget() + " invoked " + jp.getSignature() + " and threw " + thrownException);
	}
	
	
	//@Around is the most complicated, yet most powerful annotion in AOP
	//with @Around, we don't have to specify a PointCut in our parameter
	//Remember - ProceedingJoinPoint is the type of JoinPoint we use with @Around
	@Around("execution(String fight(..))")
	public String logException(ProceedingJoinPoint pjp) throws Throwable{
		Avenger a = (Avenger)pjp.getArgs()[0]; //get the Avenger object from the arguments provided in the fight method
		//why do we have to cast when using pjp.getArgs?
		//In that line, we're getting a certain argument from the fight() method. The first one in this case.
			//but Java can't predict the data type it will be, so we need to cast it. 
		
		log.info(a.getAveName() + " is about to fight!");
		double distance = (double) pjp.getArgs()[2]; //get the distance value from the fight method
		
		if(distance < 6) {
			log.warn(a.getAveName() + " is about to throw an exception!!");
			return "Looks like an exception was thrown...";
		} 
		else {
			String s = (String) pjp.proceed(); //This will actually let the fight() method run
			log.info("The fight has concluded");
			return s;
		}
		
		
		
		
	}
	
	
}
