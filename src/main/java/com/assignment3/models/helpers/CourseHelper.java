package com.assignment3.models.helpers;

import java.util.Map;

import org.apache.struts2.dispatcher.Parameter;

import com.assignment3.miscellaneous.DatabaseUtil;
import com.assignment3.models.Course;
import com.opensymphony.xwork2.ActionContext;

public class CourseHelper {

	private static final String course_id_url_param_name = "course_id";
	
	public Course getCourseFromUrlId(ActionContext context) {
		Map<String, Parameter> params = context.getParameters();
		String id = params.get(course_id_url_param_name).getValue();
		if (id != null && !id.isEmpty()) {
			Integer c_id = Integer.parseInt(id);
			return DatabaseUtil.getInstance().find(Course.class, c_id);
		}
		return null;
	}
	public static boolean validCourseName(String name) {
			if(name.isEmpty() | !isUniqueCourse(name)) {
				return false;
			}
			return true;
	}
	public static boolean validCFUName(String cfu) {
		if(cfu.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public static boolean isUniqueCourse(String name) {
		return DatabaseUtil.getInstance().findByField(Course.class, "name", name) == null;
	}
}
