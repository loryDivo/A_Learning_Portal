package com.assignment3.actions.userArea.coursesAdminActions;

import com.assignment3.actions.BaseAction;
import com.assignment3.interfaces.LoggedAdmin;

public class AddCourseAction extends BaseAction implements LoggedAdmin {

	private static final long serialVersionUID = 1L;
	
	public String execute() {
		return SUCCESS;
	}

}
