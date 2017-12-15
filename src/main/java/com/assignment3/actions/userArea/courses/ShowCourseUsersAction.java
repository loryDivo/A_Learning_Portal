package com.assignment3.actions.userArea.courses;

import java.util.List;

import com.assignment3.actions.BaseAction;
import com.assignment3.models.User;

public class ShowCourseUsersAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private List<User> users;
	
	public String execute() {
		if(getSelected_course() != null) {
			users = getSelected_course().getUsers();
		} else addActionError("Unable to retrive the selecteed course");
			
		return SUCCESS;
	}

	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}

}
