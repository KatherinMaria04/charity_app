package com.revature.controller.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.revature.dao.IUserDao;
import com.revature.dao.UserDao;
import com.revature.model.UserDetails;

public class LoginController {
	 public static String login(String cusname, String password1) {
         
	        String errorMessage = null;
	         IUserDao user = new UserDao();
	         UserDetails ud= null;
	        try {
	            ud = user.login(cusname, password1);
	             
	        } catch (Exception e) {
	            //e.printStackTrace();
	            errorMessage = e.getMessage();
	        }       
	         
	        // Prepare JSON Object
	        String json = null;
	        Gson gson = new Gson();
	        if( ud != null) {
	             json = gson.toJson(ud);
	        }
	        else if ( ud == null ) {
	            JsonObject obj = new JsonObject();
	            obj.addProperty("errorMessage", errorMessage);
	            json = obj.toString();
	        }
	         
	         
	        return json;
	         
	    }
	     
	    public static void main(String[] args) {
	         
	        System.out.println("Test Case 1: Valid User");
	        String validUserJson = LoginController.login("kathy", "pass123");
	        System.out.println(validUserJson);
	         
	        System.out.println("Test Case 2: Invalid User");
	        String invalidUserJson = LoginController.login("1123", "password");
	        System.out.println(invalidUserJson);
	         
	    }
	}


}
