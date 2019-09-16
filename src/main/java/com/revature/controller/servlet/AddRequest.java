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
import com.revature.dao.AdminDao;
import com.revature.dao.IAdminDao;
import com.revature.exception.DBException;
import com.revature.model.AdminAccess;

@WebServlet("/AddRequest")

public class AddRequest extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requesttype = request.getParameter("requestType");
	     String amountrequested  = request.getParameter("amountRquested");
	     String targetamount = request.getParameter("targetAmount");
	    
	     PrintWriter out = response.getWriter();
	     out.println("requestType:"+ requesttype);
	     out.println("amountRquested:" + amountrequested);
	     out.println("targetAmount:" + targetamount );
	     
	     IAdminDao admin  = new AdminDao();
	     AdminAccess as= new AdminAccess();
	     as.setRequesttype(requesttype);
	     as.setAmountrequested(Long.parseLong(amountrequested));
	     as.setTargetamount(Long.parseLong(targetamount));
	     
	     try {
			admin.donationsUpdate(as);
		} catch (SQLException e1) {
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     Gson gson = new Gson();
			String json = gson.toJson(as);
			
		
		
			
	}

	

}
