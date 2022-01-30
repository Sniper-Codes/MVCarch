package com.studentApp.model;
//Another name for model layer is service layer
//DAO stands for Data Access Object

public interface DAOService {
	public void connectDB();

	public boolean verifyCredentials(String email, String password);


	
	

}
