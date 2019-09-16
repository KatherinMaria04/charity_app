package com.revature.controller;

import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.dao.AdminDao;
import com.revature.model.AdminAccess;

public class AdminController {

	private AdminDao adminDao = new AdminDao();
	
	/**
	 * For all DAO methods, first write a method in controller like the below.
	 * For Success, return some json
	 * For Error, return errorMessage as json
	 * Test the below methods using main method and verify json.
	 * Servet would be easy if you write json formation in controller methods 
	 */
	
	public  String requestDetails(){
		
		String json = null;
		List<AdminAccess> requestDetails = null;
		String errorMessage = null;
		try {
			requestDetails = adminDao.requestDetails();
		} catch (SQLException e) {
			errorMessage = e.getMessage();
		}
		
		//Convert list to json
		if ( requestDetails != null) {
			Gson gson = new Gson();
			json = gson.toJson(requestDetails);
		}
		if (errorMessage != null) {
			JsonObject obj = new JsonObject();
			obj.addProperty("errorMessage", errorMessage);
		}
		return json;
		
	}
	
	public static void main(String[] args) {
		
		AdminController controller = new AdminController();
		String json = controller.requestDetails();
		System.out.println(json);
	}
}
