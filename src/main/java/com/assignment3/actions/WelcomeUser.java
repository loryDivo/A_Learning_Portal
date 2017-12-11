package com.assignment3.actions;

import com.assignment3.models.User;

public class WelcomeUser extends BaseAction {
	
	public String execute() {
		user = new User("username");
		return SUCCESS;
	}

}
