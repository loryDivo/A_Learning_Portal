package com.assignment3.actions.auth;

import com.assignment3.actions.BaseAction;
import com.assignment3.actions.NotLoggedIn;

public class LoginAction extends BaseAction implements NotLoggedIn {
	
	private static final long serialVersionUID = 1L;

	public String execute() {
		return SUCCESS;
	}
	
}
