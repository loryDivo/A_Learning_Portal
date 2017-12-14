package com.assignment3.actions.auth;

import java.util.Date;
import java.util.Map;

import com.assignment3.miscellaneous.DatabaseUtil;
import com.assignment3.models.User;

public class LoginService {
	
	public static User authenticate(String username, String password) {
		User user = DatabaseUtil.getNewInstance().findByField(User.class, "username", username);
		if(user != null) {
			if(password.equals(user.getPassword())) {
				return user;
			}
		}
		
		return null;
	}
	
	public static boolean checkIfBanned(User user) {
		if(user.getBan_until() != null) {
			Date currentDate = new Date();
			Date ban = user.getBan_until();
			if(ban.getTime() > currentDate.getTime()) return true;
		}
		return false;
	}
	
	public static void saveUserIntoSession(Integer id, Map<String, Object> session) {
		session.put("userId", (Integer)id);
	}
	
	public static void logout(Map<String, Object> session) {
		session.put("userId", null);
	}
}
