package com.assignment3.actions.userArea.courses;

import com.assignment3.actions.BaseAction;
import com.assignment3.actions.userArea.WelcomeAction;
import com.assignment3.interfaces.LoggedAdmin;

public class DoRemoveUserToCourseAction extends BaseAction implements LoggedAdmin {

	private static final long serialVersionUID = 1L;
	
	public void validate() {
		if(getSelected_user() == null) addFieldError("", "Unable to get the user");
		if(getSelected_course() == null) addFieldError("", "Unable to get the course");
	}
	
	public String execute() {
		
		CoursesService cService = new CoursesService(getSelected_user());
		cService.removeUser(getSelected_course());
		
		setEdit_action(WelcomeAction.course_user_remove);
		return SUCCESS;
	}

}
