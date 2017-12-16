package com.assignment3.actions.userArea;

import java.util.List;

import com.assignment3.actions.BaseAction;
import com.assignment3.interfaces.LoggedIn;
import com.assignment3.miscellaneous.DatabaseUtil;
import com.assignment3.models.Course;
import com.assignment3.models.User;
import com.assignment3.models.helpers.UsersHelper;

public class WelcomeAction extends BaseAction implements LoggedIn {
	
	private static final long serialVersionUID = 1L;
	
	public static final int edit_user = 1;
	private static final String edit_user_message = "User edited correctly";
	public static final int edit_password = 2;
	private static final String edit_password_message = "Password edited correctly";
	public static final int ban_user = 3;
	private static final String ban_user_message = "User banned correctly";
	public static final int ban_user_removed = 4;
	private static final String ban_user_removed_message = "Ban removed";
	public static final int course_add = 5;
	private static final String course_add_message = "Course addedd correctly";
	public static final int course_edit = 6;
	private static final String course_edit_message = "Course edited correctly";
	public static final int course_remove = 7;
	private static final String course_remove_message = "Course removed correctly";
	public static final int course_user_remove = 8;
	private static final String course_user_remove_message = "User removed correctly";

	private String message;
	private List<User> users;
	private List<Course> courses;
	private List<Course> remaining_courses;
	
	
	public String execute() {
		//check if is a redirect from edit page and show the message
		String message = getMessageString();
		if(message != null) addActionMessage(message);
		
		setUsers(DatabaseUtil.getInstance().getAll(User.class));
		setCourses(DatabaseUtil.getInstance().getAll(Course.class));
		
		UsersHelper uHelper = new UsersHelper(user);
		setRemaining_courses(uHelper.getRemainingCourses(courses));
		
		return SUCCESS;
	}
	
	public List<Course> getRemaining_courses() {
		return remaining_courses;
	}
	public void setRemaining_courses(List<Course> remaining_courses) {
		this.remaining_courses = remaining_courses;
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	private String getMessageString() {
		try {
			int eValue = Integer.parseInt(getMessage());
			if(eValue == edit_user) return edit_user_message;
			else if(eValue == edit_password) return edit_password_message;
			else if(eValue == ban_user) return ban_user_message;
			else if(eValue == ban_user_removed) return ban_user_removed_message;
			else if(eValue == course_add) return course_add_message;
			else if(eValue == course_edit) return course_edit_message;
			else if(eValue == course_remove) return course_remove_message;
			else if(eValue == course_user_remove) return course_user_remove_message;
		} catch(Exception e) {
			//either there is no edit action or user must change the url
		}
		
		return null;
	}
}
