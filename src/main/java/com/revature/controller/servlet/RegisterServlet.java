package com.revature.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import com.revature.dao.IUserDao;
import com.revature.dao.UserDao;
import com.revature.exception.DBException;
import com.revature.model.UserDetails;


/**
 * Servlet implementation class RegisterServlet
 */

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String customername= request.getParameter("username");
	      String password = request.getParameter("password");
	      String phoneno   = request.getParameter("phonenumber");
	    
	     PrintWriter out = response.getWriter();
	     System.out.println("username:"+ customername);
	    System.out.println("password:" + password);
	    System.out.println("phonenumber:" + phoneno);
	     IUserDao user  = new UserDao();
	     UserDetails ud= new UserDetails();
	     ud.setCustomername(customername);
	     ud.setPassword(password);
	     ud.setPhoneno(Long.parseLong(phoneno));
				try {
					user.register(customername, password, Long.parseLong(phoneno));
				
				} catch (DBException e) {
				
					e.printStackTrace();
				}
			
			}
		
			
		
	    
		
			
	}

	


