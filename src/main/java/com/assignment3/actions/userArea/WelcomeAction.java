package com.assignment3.actions.userArea;

import java.util.List;

import com.assignment3.actions.BaseAction;
import com.assignment3.actions.LoggedIn;
import com.assignment3.miscellaneous.DatabaseUtil;
import com.assignment3.models.Course;
import com.assignment3.models.User;

public class WelcomeAction extends BaseAction implements LoggedIn {
	
	private static final long serialVersionUID = 1L;

	private List<User> users;
	private List<Course> courses;
	
	public String execute() {
		setUsers(DatabaseUtil.getNewInstance().getAll(User.class));
		//setCourses(DatabaseUtil.getNewInstance().getAll(Course.class));
		return SUCCESS;
	}
	
	
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> list) {
		this.users = list;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
}
