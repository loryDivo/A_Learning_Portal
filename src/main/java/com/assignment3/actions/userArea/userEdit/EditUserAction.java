package com.assignment3.actions.userArea.userEdit;

import com.assignment3.actions.BaseAction;
import com.assignment3.interfaces.LoggedIn;
import com.assignment3.models.helpers.UsersHelper;

public class EditUserAction extends BaseAction implements LoggedIn {
	
	private static final long serialVersionUID = 1L;
	
	private String ban_until_message;

	public String execute() {
		if(getSelected_user() != null) setAdmin_editing(true);
		else setSelected_user(user);
		
		if(getSelected_user().isBanned()) {
			UsersHelper uHelper = new UsersHelper(getSelected_user());
			String message = uHelper.getBanMessage();
			if(message != null) setBan_until_message("The user is banned " + message);
		}
		
		return SUCCESS;
	}

	public String getBan_until_message() {
		return ban_until_message;
	}
	public void setBan_until_message(String ban_until_message) {
		this.ban_until_message = ban_until_message;
	}	
}
