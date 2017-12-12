package com.assignment3.actions;

import java.util.ArrayList;

import com.assignment3.models.Course;
import com.assignment3.models.User;

public class WelcomeAction extends BaseAction implements LoggedIn {
	
	private static final long serialVersionUID = 1L;

	private ArrayList<User> users;
	private ArrayList<Course> courses;
	
	public String execute() {
		setUsers(User.getAll());
		setCourses(Course.getAll());
		return SUCCESS;
	}
	
	
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	public ArrayList<Course> getCourses() {
		return courses;
	}
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
}
