package com.assignment3.actions.userArea.coursesAdminActions;

import java.util.List;

import com.assignment3.miscellaneous.DatabaseUtil;
import com.assignment3.models.Course;
import com.assignment3.models.User;

public class CoursesService {
	
	private User user;
	
	public CoursesService(User user) {
		this.user = user;
	}
	
	public static void createNewCourse(String name, String cfu) {
		Course course = new Course(name, Integer.parseInt(cfu));
		DatabaseUtil.getInstance().save(course);
	}
	
	public static void editCourse(Course course, String name, String cfu) {
		course.setName(name);
		course.setCFU(Integer.parseInt(cfu));
		DatabaseUtil.getInstance().update(course);
	}
	
	public static void removeCourse(Course course) {
		List<User> users = course.getUsers();
		for(User user : users) user.getCourses().remove(course);
		DatabaseUtil.getInstance().remove(course);
	}
	
	public void removeUser(Course course) {
		user.getCourses().remove(course);
		List<User> users = course.getUsers();
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getId() == user.getId()) {
				course.getUsers().remove(i);
				return;
			}
		}
	}

}
