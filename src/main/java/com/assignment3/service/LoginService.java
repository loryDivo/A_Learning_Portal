package com.assignment3.service;

import java.util.Map;

public class LoginService {
	
	public static Integer authenticate(String username, String password) {
		if(username.equals("admin") && password.equals("admin")) return 1;
		else if(username.equals("user") && password.equals("user")) return 2;
		
		
		return null;
	}
	
	public static void saveUserIntoSession(Integer id, Map<String, Object> session) {
		session.put("userId", (Integer)id);
	}
	
	public static void logout(Map<String, Object> session) {
		session.put("userId", null);
	}
}
