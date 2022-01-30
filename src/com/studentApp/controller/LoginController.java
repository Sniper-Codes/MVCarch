package com.studentApp.controller;
//Controller will not do DB work strictly, Model layer would do DB work

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentApp.model.DAOService;
import com.studentApp.model.DAOServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//Runtime polymorphism - child object address storing it in parent class reference variable 
		//and that becomes runtime polymorhism
		
		DAOService service = new DAOServiceImpl();
		service.connectDB(); // controll comes back to controller layer
		
		boolean status = service.verifyCredentials(email,password);
		
		if (status==true) {
			System.out.println("Welcome");
			}else {
				System.out.println("invalid");
			}
	       }

}
