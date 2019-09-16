package com.revature.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.dao.AdminDao;
import com.revature.dao.IAdminDao;
import com.revature.model.AdminAccess;
import com.revature.service.AdminFunctions;

@WebServlet("/ListRequest")
public class ListRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IAdminDao dao= new AdminDao();
	       List<AdminAccess> list =null;
		 try {
		    	
		     list=dao.requestDetails();
		       AdminFunctions.display(list);
		     
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		PrintWriter out = response.getWriter();
		out.println(json);
		
	}

	
}
