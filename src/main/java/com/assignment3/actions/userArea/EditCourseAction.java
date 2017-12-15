package com.assignment3.actions.userArea;

import com.assignment3.actions.BaseAction;
import com.assignment3.interfaces.LoggedIn;
import com.assignment3.miscellaneous.DatabaseUtil;
import com.assignment3.models.Course;
import com.assignment3.models.User;
import com.assignment3.models.helpers.CourseHelper;

public class EditCourseAction extends BaseAction implements LoggedIn{
	
	private static final long serialVersionUID = 1L;
	
	private String cfu;
	private String name;
	
	public void validate() {
		/*if(!CourseHelper.validCourseName(getName())) {
			addFieldError("name", "name is not valid");
		}
		if(!CourseHelper.validCFUName(getCfu())) {
			addFieldError("cfu", "cfu is not valid");
		}*/
	}
	
	public String execute() {
		createNewCourse(getName(), getCfu());
		return SUCCESS;
	}
	
	public void createNewCourse(String name, String cfu) {
		//Course course = new Course(name, cfu);
		User user = DatabaseUtil.getInstance().findByField(User.class, "id", session.get("userId"));
		//user.addCourse(course);
		//course.addUser(user);
		//DatabaseUtil.getInstance().save(course);
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
