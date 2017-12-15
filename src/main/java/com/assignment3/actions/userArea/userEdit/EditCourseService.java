package com.assignment3.actions.userArea.userEdit;

import com.assignment3.miscellaneous.DatabaseUtil;
import com.assignment3.models.Course;

public class EditCourseService {

	private Course course;
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public EditCourseService(Course course) {
		setCourse(course);
	}
	public void editCourse(String name, String CFU) {
		course.setName(name);
		course.setCFU(CFU);
		DatabaseUtil.getInstance().update(course);
	}
}
