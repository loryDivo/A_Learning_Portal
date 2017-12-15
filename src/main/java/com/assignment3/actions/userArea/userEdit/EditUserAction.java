package com.assignment3.actions.userArea.userEdit;

import com.assignment3.actions.BaseAction;
import com.assignment3.interfaces.LoggedIn;
import com.assignment3.models.User;

public class EditUserAction extends BaseAction implements LoggedIn {
	
	private static final long serialVersionUID = 1L;

	public String execute() {
		setEditUserOnExecute();
		
		return SUCCESS;
	}	

}
