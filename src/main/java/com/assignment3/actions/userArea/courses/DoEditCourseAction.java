package com.assignment3.actions.userArea.courses;

import com.assignment3.actions.BaseAction;
import com.assignment3.actions.userArea.WelcomeAction;
import com.assignment3.interfaces.LoggedAdmin;
import com.assignment3.models.helpers.CourseHelper;

public class DoEditCourseAction extends BaseAction implements LoggedAdmin {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String cfu;
	
	public void validate() {
		if(getSelected_course() == null) addFieldError("", "Unable to get the course");
		if(getName().isEmpty()) addFieldError("name", "Name required");
		else if(!CourseHelper.isUniqueName(getName(), getSelected_course())) addFieldError("name", "Course already added");
		
		if(getCfu().isEmpty()) addFieldError("cfu", "Cfu required");
		else if(!CourseHelper.isValidCfu(getCfu())) addFieldError("cfu", "Cfu must be a number");
	}
	
	public String execute() {
		CoursesService.editCourse(getSelected_course(), getName(), getCfu());
		
		setEdit_action(WelcomeAction.course_edit);
		return SUCCESS;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCfu() {
		return cfu;
	}
	public void setCfu(String cfu) {
		this.cfu = cfu;
	}

}
