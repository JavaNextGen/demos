package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;

public class RoleDAO {

public void updateSalary(String roleTitle, int salary) {
		
		try(Connection conn = ConnectionFactory.getConnection()){
			
			String sql = "update roles set role_salary = ? where role_title = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, salary);
			ps.setString(2, roleTitle);
			
			ps.executeUpdate();
			
			System.out.println(roleTitle + " salary has been updated to: " + salary);
			
		} catch (SQLException e) {
			System.out.println("You can't update salaries in this economy!!!");
			e.printStackTrace();
		}

	}
	
}
