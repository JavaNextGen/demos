package com.revature.repositories;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
	
	//HQL is best used if you're SELECTing ALL from the DB. If you want to SELECT BY, you should use sessions methods (below)
	public List<Movie> getAllMovies(){
		
		//open a Session object
		Session ses = HibernateUtil.getSession();
		
		//SELECT all movies, with HQL instead of session methods, and put the values into a List (this will be one line)
		List<Movie> movieList = ses.createQuery("FROM Movie").list();
		
		//close the session
		HibernateUtil.closeSession();
		
		//return the List of Movies
		
		return movieList; 
		
	}
	
	//Session methods are best used when you're SELECTing by the primary key, 
	//because get() and load() both expect a serializable (which our primary key is)
	public Movie getMovieById(int id){
		
		//open a Session object
		Session ses = HibernateUtil.getSession();
		
		//SELECT all movies by ID (which should just be one movie)
		Movie movie = ses.get(Movie.class, id);
		
		//close the session
		HibernateUtil.closeSession();
		
		//return the List of Movies
		return movie; 
	}
	
	//get all Movies by Director with HQL
	//check the HQL query - we need to look for the director.id, since we're searching for Movie.director.id here
	public List<Movie> getMoviesByDirectorId(int id){
		
		Session ses = HibernateUtil.getSession();
		
		//Create a query with a parameter that takes in the director id (the id given in the method's parameters)
		Query q = ses.createQuery("FROM Movie m WHERE m.director.id = ?0");
		
		//set the ? to the id sent in to the method call
		q.setParameter(0, id);
		
		//create a List to hold the results of the query
		List<Movie> movieList = q.getResultList();
		
		HibernateUtil.closeSession();
		
		return movieList;
		
	}
	
	//Using session method to update
	public void UpdateMovieWithSessionMethod(Movie movie) {
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tran = ses.beginTransaction();
		
		ses.merge(movie);
		
		tran.commit(); 
		HibernateUtil.closeSession();
		
	}
	
	//Using HQL to update 
	public void updateMovieWithHQL(Movie movie) {
		
		Session ses = HibernateUtil.getSession();
		
		Transaction tran = ses.beginTransaction(); //all update and delete methods must happen within a transaction
		
		//updates and deletes take a little bit more work... You should put the query in a Query object 
		//and then you'll have to make sure to run executeUpdate(), similar to in JDBC
		
		//Assign the Query syntax to a query object
		Query q = ses.createQuery("UPDATE Movie SET title = '" + movie.getTitle() + "' WHERE id = " + movie.getId());
		//think of this syntax like how we would write it in SQL: UPDATE movie SET title = 'newTitle' WHERE movie_id = ?; 
		
		//Send the update to the DB with executeUpdate();
		q.executeUpdate();
		
		//close the transaction and session
		tran.commit(); 
		HibernateUtil.closeSession();
		
	}
	

	
}
