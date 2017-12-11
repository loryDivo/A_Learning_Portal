package com.assignment3.actions;

import com.assignment3.service.LoginService;

public class LoginAction extends BaseAction {
	
	private String username;
	private String password;
	
	public void validate() {
		if(username == null) addFieldError("username", "Ciao");
	}
	
	public String execute() {
		LoginService service = new LoginService();
		int result = service.authenticate(username, password);
		if(result == LoginService.IS_ADMIN) return "admin";
		else if(result == LoginService.IS_USER) return "user";
		
		return LOGIN;
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
