package com.assignment3.service;

import java.util.Map;

import com.assignment3.miscellaneous.JPALogic;
import com.assignment3.models.User;

public class LoginService {
	
	public static User authenticate(String username, String password) {
		User user = (User)(JPALogic.getInstance().jpaRead("SELECT  username " + ", " + "password " + " FROM User "
				+ "WHERE username = " + username + " AND password = " + password, User.class).getSingleResult());
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
