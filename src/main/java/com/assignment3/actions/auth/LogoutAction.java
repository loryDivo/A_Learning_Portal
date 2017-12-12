package com.assignment3.actions.auth;

import com.assignment3.actions.BaseAction;
import com.assignment3.service.LoginService;

public class LogoutAction extends BaseAction{
	
	public String execute() {
		LoginService.logout(session);
		
		return SUCCESS;
	}
}
