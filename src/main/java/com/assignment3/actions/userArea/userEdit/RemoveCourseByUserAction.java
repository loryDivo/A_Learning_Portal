package com.assignment3.actions.userArea.userEdit;

import com.assignment3.actions.BaseAction;
import com.assignment3.interfaces.LoggedIn;
import com.assignment3.miscellaneous.DatabaseUtil;

public class RemoveCourseByUserAction extends BaseAction implements LoggedIn{
	
	public String execute() {
		user.getCourses().remove(selected_course);
		return SUCCESS;
	}
}
