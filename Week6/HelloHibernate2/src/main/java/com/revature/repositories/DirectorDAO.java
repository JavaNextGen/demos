package com.revature.repositories;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Director;
import com.revature.utils.HibernateUtil;

public class DirectorDAO {

	public List<Director> getAllDirectors(){
		
		Session ses = HibernateUtil.getSession();
		
		//remember, HQL references the Java Class, so we look for Director (Java Class) as opposed to directors (SQL Entity)
		List<Director> directorList = ses.createQuery("FROM Director").list();
		
		HibernateUtil.closeSession();
		
		return directorList;
		
	}
	
}
