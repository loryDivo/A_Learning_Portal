package com.assignment3.actions.userArea;


import java.util.Date;

import com.assignment3.miscellaneous.DatabaseUtil;
import com.assignment3.models.User;

public class EditUserService {
	
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
		user.setPassword(password);
		DatabaseUtil.getInstance().update(user);
	}
	
	public boolean oldPasswordCorrect(String password) {
		return user.getPassword().equals(password);
	}
	
	public void editBan(Date ban) {
		//add or remove ban
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
