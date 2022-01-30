package com.studentApp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {
	
	private Connection con;
	private Statement stmnt;
	
	
	

	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/studentdb2", "root" , "save");
			stmnt = con.createStatement();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}




	@Override
	public boolean verifyCredentials(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email='"+email+"' and password ='"+password+"' " );
			return result.next();
				} catch (Exception e) {
				e.printStackTrace();
				}
		return false;
	}




	

}

//What is Abstraction?
//Hiding of implementation data is called abstraction and the way we achieve in java is by interface 
//and abstract classes
//Where have you used this practically/
//In project i was developing interface layer called as DAOService where i defined all the incomplete methods
//and implemented that in the class DAOServiceImpl where in i have written down database queries.
//where did you achieve polymorphism?
//Developing a feature such that it takes a different form is called as polymorphism and the way i achieved in my project is i inherited the incomplete methods and completed in class.  