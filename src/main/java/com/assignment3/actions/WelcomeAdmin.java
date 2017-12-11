package com.assignment3.actions;

import com.assignment3.models.User;

public class WelcomeAdmin extends BaseAction {
	
	public String execute() {
		user = new User("prova user");
		return SUCCESS;
	}
}
