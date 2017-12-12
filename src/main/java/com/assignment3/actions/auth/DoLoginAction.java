package com.assignment3.actions.auth;

import com.assignment3.actions.BaseAction;
import com.assignment3.actions.NotLoggedIn;
import com.assignment3.service.LoginService;

public class DoLoginAction extends BaseAction implements NotLoggedIn {
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	
	public void validate() {
		if(getUsername() == null || getUsername().equals("")) addFieldError("username", "The username field is required");
		if(getPassword() == null || getPassword().equals("")) addFieldError("password", "The username field is required");
	}
	
	public String execute() {
		Integer userId = LoginService.authenticate(username, password);
		if(userId != null) {
			LoginService.saveUserIntoSession(userId, session);
			return SUCCESS;
		} else return ERROR;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
