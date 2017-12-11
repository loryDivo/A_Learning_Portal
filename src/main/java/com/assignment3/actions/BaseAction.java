package com.assignment3.actions;

import com.assignment3.models.User;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport {
	
	protected User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
