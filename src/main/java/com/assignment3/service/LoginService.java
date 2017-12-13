package com.assignment3.service;

import java.util.Map;

import com.assignment3.models.User;
import com.assignment3.modelsDAO.UserDAO;

public class LoginService {
	
	public static User authenticate(String username, String password) {
		User user = UserDAO.find(1);
		if(user != null) {
			if(password.equals(user.getPassword())) {
				return user;
			}
		}
		
		return null;
	}
	
	public static void saveUserIntoSession(Integer id, Map<String, Object> session) {
		session.put("userId", (Integer)id);
	}
	
	public static void logout(Map<String, Object> session) {
		session.put("userId", null);
	}
}
