package com.assignment3.actions.userArea.userEdit;


import com.assignment3.actions.BaseAction;
import com.assignment3.interfaces.LoggedIn;
import com.assignment3.miscellaneous.DatabaseUtil;
import com.assignment3.models.Course;
import com.assignment3.models.helpers.CourseHelper;

public class AddCourseByUserAction extends BaseAction implements LoggedIn{


	public String execute() {
		user.getCourses().add(selected_course);
		selected_course.addUser(user);
		DatabaseUtil.getInstance().save(selected_course);
		return SUCCESS;
	}
	
}
