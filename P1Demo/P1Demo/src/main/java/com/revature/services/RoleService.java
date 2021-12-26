package com.revature.services;

import com.revature.repositories.RoleDAO;

public class RoleService {

	RoleDAO rDAO = new RoleDAO();

	public void updateSalary(String titleInput, int salaryInput) {
		
		rDAO.updateSalary(titleInput, salaryInput);
		
	}
	
}
