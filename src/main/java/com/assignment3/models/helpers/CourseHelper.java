package com.assignment3.models.helpers;

import java.util.Map;

import org.apache.struts2.dispatcher.Parameter;

import com.assignment3.models.Course;
import com.assignment3.utils.DatabaseUtil;
import com.opensymphony.xwork2.ActionContext;

public class CourseHelper {

	private static final String course_id_url_param_name = "course_id";
	
	public static Course getCourseFromUrlId(ActionContext context) {
		Map<String, Parameter> params = context.getParameters();
		String id = params.get(course_id_url_param_name).getValue();
		if (id != null && !id.isEmpty()) {
			Integer c_id = Integer.parseInt(id);
			return DatabaseUtil.getInstance().find(Course.class, c_id);
		}
		return null;
	}
	public static boolean isUniqueName(String name) {
		return DatabaseUtil.getInstance().findByField(Course.class, "name", name) == null;
	}
	public static boolean isUniqueName(String name, Course course) {
		Course finded_course = DatabaseUtil.getInstance().findByField(Course.class, "name", name);
		
		if(finded_course == null) return true;
		
		return finded_course.getId() == course.getId();
	}
	public static boolean isValidCfu(String cfu) {
		try {
			int int_cfu = Integer.parseInt(cfu);
			if(int_cfu > 0 && int_cfu <= 20) return true;
		} catch(Exception e) {
			//
		}
		return false;
	}
}
