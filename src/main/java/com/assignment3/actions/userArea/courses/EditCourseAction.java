package com.assignment3.actions.userArea.courses;

import com.assignment3.actions.BaseAction;
import com.assignment3.interfaces.LoggedAdmin;

public class EditCourseAction extends BaseAction implements LoggedAdmin {

	private static final long serialVersionUID = 1L;
	
	public String execute() {
		return SUCCESS;
	}

}
