package com.revature;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.models.Director;
import com.revature.models.Movie;
import com.revature.repositories.DirectorDAO;
import com.revature.repositories.MovieDAO;
import com.revature.utils.HibernateUtil;

public class Launcher {

	public static void main(String[] args) {
		
		MovieDAO mDAO = new MovieDAO(); //MovieDAO object so we can use its methods
		DirectorDAO dDAO = new DirectorDAO(); //AuthorDAO object so we can use its method
		
		//This try with resources is good for checking that your DB is connected
		//But we should comment it out once we know we're connected, because it will close the Session
		//For EVERYTHING that the main method calls afterwards.
		
//		try(Session ses = HibernateUtil.getSession()) {
//			System.out.println("Connection Successful");
//		} catch (HibernateException e) {
//			System.out.println("Connection Failed!");
//			e.printStackTrace();
//		}
		
		
		//going to create some Director and Movie objects to insert into the database---------------------
		
		//we can leave this null, because the Movie class has a reference to Directors
		//Because of the parameters we left in the @OneToMany and @ManyToOne, hibernate knows what to fill these nulls with
		//....(which is a list of Movies)
		Director d1 = new Director("Quentin", "Tarantino", 1963, null); 
		Director d2 = new Director("Michael", "Bay", 1965, null); 
		Director d3 = new Director("Jordan", "Peele", 1979, null); 
		//had to create a new constructor to demonstrate with d3 that null values will just be given default values
		
		Movie m1 = new Movie("Pulp Fiction", "Action", d1);
		Movie m2 = new Movie("Transformers", "Action", d2);
		Movie m3 = new Movie("Us", "Thriller", d3);
		
		//insert our Movie objects into the database
		mDAO.insertMovie(m1);
		mDAO.insertMovie(m2);
		mDAO.insertMovie(m3);
		
		//select our Movies from the DB
		
		//select all
		List<Movie> allMovies = mDAO.getAllMovies();
		
		for(Movie m : allMovies) {
			System.out.println(m);
		}
		
		//select by id
		System.out.println(mDAO.getMovieById(2));
		
		//select by Director id
		System.out.println(mDAO.getMoviesByDirectorId(1));

		//update a movie
		m1.setTitle("SOMETHING ELSE"); //change the title in Java
		
		//mDAO.updateMovieWithHQL(m1); //send the update with the HQL method
		
		mDAO.UpdateMovieWithSessionMethod(m1); //send the update with the Session method
		
		System.out.println(mDAO.getMovieById(1)); //select the movie to make sure the change went through
		
		
		//print out all of my Directors (which will have a List of Movies)
		
		List<Director> allDirectors = dDAO.getAllDirectors();
		
		for(Director d : allDirectors) {
			System.out.println(d);
		}
		
	}

}
