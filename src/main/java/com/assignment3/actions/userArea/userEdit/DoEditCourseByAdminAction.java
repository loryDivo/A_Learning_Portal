package com.assignment3.actions.userArea.userEdit;

import com.assignment3.actions.BaseAction;
import com.assignment3.interfaces.LoggedIn;
import com.assignment3.models.helpers.CourseHelper;

public class DoEditCourseByAdminAction extends BaseAction implements LoggedIn{
	
	public void Validate() {
		/*if(CourseHelper.validCourseName(selected_course.getName())) {
			addFieldError("name", "name is not valid");
		}
		if(CourseHelper.validCFUName(selected_course.getName())) {
			addFieldError("cfu", "cfu is not valid");
		}*/
	}
	
	public String execute() {
		return SUCCESS;
	}
}
