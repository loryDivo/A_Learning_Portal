package com.assignment3.actions.userArea.coursesAdminActions;

import com.assignment3.actions.BaseAction;
import com.assignment3.actions.userArea.WelcomeAction;
import com.assignment3.interfaces.LoggedAdmin;

public class DoRemoveCourseAction extends BaseAction implements LoggedAdmin {

	private static final long serialVersionUID = 1L;
	
	public void validate() {
		if(getSelected_course() == null) addFieldError("", "Unable to load the selected course");
	}
	
	public String execute() {
		CoursesService.removeCourse(getSelected_course());
		
		setWelcome_message(WelcomeAction.course_remove);
		return SUCCESS;
	}

}
