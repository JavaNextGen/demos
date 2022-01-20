package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Movie;
import com.revature.utils.HibernateUtil;

public class MovieDAO {

	//Hibernate DAO methods incorporate the sessions objects methods to create/manipulate data (SESSION METHODS)
	//read up on the session methods in the notes to understand what's going on here
	
	public void insertMovie(Movie movie) {
		
		//open a Session object to establish a connection to the DB
		Session ses = HibernateUtil.getSession(); //similar to opening a connection in JDBC
		
		//insert the movie into the DB
		ses.save(movie);
		
		//close the Session object to prevent memory leaks
		HibernateUtil.closeSession();
		
		//This is the ENTIRE insert method - much cleaner and less complicated than JDBC :)
		
	}
	
	public List<Movie> getAllMovies(){
		
		//open a Session object
		
		//SELECT all movies, with HQL instead of session methods, and put the values into a List (this will be one line)
		
		//close the session
		
		//return the List of Movies
		
		
		return null; //just so the error goes away for now
		
	}
	
	
	
	
	
}
