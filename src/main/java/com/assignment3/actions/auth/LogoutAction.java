package com.assignment3.actions.auth;

import com.assignment3.actions.BaseAction;

public class LogoutAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	public String execute() {
		LoginService.logout(session);
		
		return SUCCESS;
	}
}
