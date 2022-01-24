package com.revature.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //generic stereotype annotation - User is now a Bean
@Scope("prototype") //Remember the default bean scope is Singleton
public class User {

	private int id;
	private String name;
	
	//@Autowired //autowiring the Account bean using FIELD INJECTION (bad practice) (1 of 3 types of dependency injection) 
	private Account account;

	
	//boilerplate code--------------------------------------------
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int id, String name, Account account) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
	}

	//We created this constructor in order to accomplish AutoWiring in our Config Class
	@Autowired //autowiring our Account Bean with CONSTRUCTOR INJECTION (1 of the 3 types of dependency injection)
	public User(Account accountBean) {
		this.account = accountBean;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", account=" + account + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Account getAccount() {
		return account;
	}


	//@Autowired //Autowiring the Account Bean using SETTER INJECTION (1 of the 3 types of dependency injection
	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
}
