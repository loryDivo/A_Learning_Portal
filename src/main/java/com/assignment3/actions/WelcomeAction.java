package com.assignment3.actions;

import java.util.ArrayList;

import com.assignment3.models.Course;
import com.assignment3.models.User;

public class WelcomeAction extends BaseAction implements LoggedIn {
	
	private static final long serialVersionUID = 1L;

	private ArrayList<User> userList;
	private ArrayList<Course> courseList;
	
	public ArrayList<Course> getCourseList() {
		return courseList;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	
	public void setCourseList(ArrayList<Course> courseList) {
		this.courseList = courseList;
	}
	
	public String execute() {
		user = new User("username", "password", "name","lastname", "email@email.it");
		setCourseList(user.getAllCourse());
		setUserList(user.getAllUser());
		return SUCCESS;
	}
}
