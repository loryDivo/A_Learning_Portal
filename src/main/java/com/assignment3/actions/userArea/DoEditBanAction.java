package com.assignment3.actions.userArea;

import java.util.Date;

import com.assignment3.actions.BaseAction;
import com.assignment3.actions.LoggedIn;
import com.assignment3.miscellaneous.DatabaseUtil;
import com.assignment3.models.User;

public class DoEditBanAction extends BaseAction implements LoggedIn {
	
	private static final long serialVersionUID = 1L;
	private String user_id;
	private Date ban;
	private User selected_user;
	
	public void validate() {
		if(user_id == null || user_id.isEmpty()) addFieldError("", "Missing user id");
		Integer id = Integer.parseInt(user_id);
		selected_user = DatabaseUtil.getInstance().find(user.getClass(), id);
		if(user == null) addFieldError("", "User id incorrect");
		if(user.isAdmin()) addFieldError("", "You cannot edit admin ban");
	}
	
	public String execute() {
		EditUserService service = new EditUserService(selected_user);
		service.editBan(ban);
		
		return SUCCESS;
	}

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	

}
