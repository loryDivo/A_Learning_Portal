package com.assignment3.actions.userArea;

import java.util.List;

import com.assignment3.actions.BaseAction;
import com.assignment3.interfaces.LoggedIn;
import com.assignment3.miscellaneous.DatabaseUtil;
import com.assignment3.models.Course;
import com.assignment3.models.User;

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

	private String edit;
	private List<User> users;
	private List<Course> courses;
	
	public String execute() {
		//check if is a redirect from edit page and show the message
		String message = getMessageFromEdit();
		if(message != null) addActionMessage(message);
		
		setUsers(DatabaseUtil.getInstance().getAll(User.class));

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
	public String getEdit() {
		return edit;
	}
	public void setEdit(String edit) {
		this.edit = edit;
	}
	
	private String getMessageFromEdit() {
		try {
			int eValue = Integer.parseInt(edit);
			if(eValue == edit_user) return edit_user_message;
			else if(eValue == edit_password) return edit_password_message;
			else if(eValue == ban_user) return ban_user_message;
			else if(eValue == ban_user_removed) return ban_user_removed_message;
		} catch(Exception e) {
			//either there is no edit action or user must change the url
		}
		
		return null;
	}
}
