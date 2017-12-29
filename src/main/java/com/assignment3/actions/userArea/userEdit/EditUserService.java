package com.assignment3.actions.userArea.userEdit;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.assignment3.models.User;
import com.assignment3.models.helpers.UsersHelper;
import com.assignment3.utils.DatabaseUtil;

public class EditUserService {
	
	public static final String ban_forever_date = "9999-12-12 00:00:00";
	public static final String ban_forever_date_format = "yyyy-MM-dd HH:mm:ss";
	
	private User user;
	
	public EditUserService(User user) {
		setUser(user);
	}
	
	public void editUser(String name, String last_name, String city, String country) {
		user.setName(name);
		user.setLast_name(last_name);
		user.setCity(city);
		user.setCountry(country);
		DatabaseUtil.getInstance().update(user);
	}
	
	public void editPassword(String password) {
		String hashedPassword = UsersHelper.getHashedPassword(password);
		user.setPassword(hashedPassword);
		DatabaseUtil.getInstance().update(user);
	}
	
	public boolean isOldPasswordCorrect(String password) {
		UsersHelper uHelper = new UsersHelper(user);
		return uHelper.checkPassword(password);
	}
	
	public void editBan(String ban, Boolean ban_forever) {
		String format = DoEditBanAction.date_format;
		String dateToParse = ban;
		Date banUntil = null;
		
		//Change format if is a forever ban
		if(ban_forever != null && ban_forever == true) {
			format = ban_forever_date_format;
			dateToParse = ban_forever_date;
		}
		
		DateFormat formatter = new SimpleDateFormat(format);
		//Try to parse the date using the format previously set
		try {
			banUntil = formatter.parse(dateToParse);
		} catch (Exception e) {
			//Mandatory try/catch for parsing the date. Will be always true because date's format is checked during validation
			
		}
		
		user.setBan_until(banUntil);
		DatabaseUtil.getInstance().update(user);
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
