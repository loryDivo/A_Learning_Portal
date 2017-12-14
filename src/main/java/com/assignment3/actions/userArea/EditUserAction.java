package com.assignment3.actions.userArea;

import com.assignment3.actions.BaseAction;
import com.assignment3.actions.LoggedIn;
import com.assignment3.miscellaneous.DatabaseUtil;
import com.assignment3.models.User;

public class EditUserAction extends BaseAction implements LoggedIn {
	
	private static final long serialVersionUID = 1L;
	
	private String user_id;
	private User edit_user;
	private boolean admin_editing = false;

	public String execute() {
		setEdit_user(user);
		if(user_id != null && !user_id.isEmpty() && user.isAdmin()) {
			Integer id = Integer.parseInt(user_id); 
			User selected_user = DatabaseUtil.getNewInstance().find(User.class, id);
			
			if(selected_user != null) {
				setEdit_user(selected_user);
				setAdmin_editing(true);
			}
		}
		return SUCCESS;
	}

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public User getEdit_user() {
		return edit_user;
	}
	public void setEdit_user(User edit_user) {
		this.edit_user = edit_user;
	}
	public boolean isAdmin_editing() {
		return admin_editing;
	}
	public void setAdmin_editing(boolean admin_editing) {
		this.admin_editing = admin_editing;
	}
	
}
