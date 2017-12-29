package com.assignment3.actions.auth;

import java.util.Map;

import com.assignment3.models.User;
import com.assignment3.models.helpers.UsersHelper;
import com.assignment3.utils.DatabaseUtil;

public class LoginService {
	
	public static User authenticate(String username, String password) {
		User user = DatabaseUtil.getInstance().findByField(User.class, "username", username);
		if(user != null) {
			UsersHelper uHelper = new UsersHelper(user);
			if(uHelper.checkPassword(password))
				return user;
		}
		
		return null;
	}
	
	public static String checkIfBanned(User user) {
		UsersHelper uHelper = new UsersHelper(user);
		return uHelper.getBanMessage();
	}
	
	public static void saveUserIntoSession(Integer id, Map<String, Object> session) {
		session.put("userId", (Integer)id);
	}
	
	public static void logout(Map<String, Object> session) {
		session.put("userId", null);
	}
}
