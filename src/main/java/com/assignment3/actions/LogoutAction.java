package com.assignment3.actions;

import com.assignment3.service.LoginService;

public class LogoutAction extends BaseAction {
	
	public String execute() {
		LoginService service = new LoginService();
		service.logout();
		
		return SUCCESS;
	}
}
