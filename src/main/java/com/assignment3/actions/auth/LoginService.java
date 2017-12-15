package com.assignment3.actions.auth;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.assignment3.actions.userArea.userEdit.EditUserService;
import com.assignment3.miscellaneous.DatabaseUtil;
import com.assignment3.models.User;
import com.assignment3.models.helpers.UsersHelper;

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
		if(user.getBan_until() != null) {
			Date currentDate = new Date();
			Date ban = user.getBan_until();
			if(ban.getTime() > currentDate.getTime()) {
				Date ban_until = user.getBan_until();
				
				SimpleDateFormat dt = new SimpleDateFormat("dd MMMM yyyy");
				String message = "until " + dt.format(ban_until);
				
				//get the correct format for compare the date to the forever date
				SimpleDateFormat dtForever = new SimpleDateFormat(EditUserService.ban_forever_date_format);
				if(dtForever.format(ban_until).equals(EditUserService.ban_forever_date)) message = "Forever";
				
				return message;
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
