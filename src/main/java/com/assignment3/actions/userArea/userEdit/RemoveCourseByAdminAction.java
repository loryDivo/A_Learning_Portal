package com.assignment3.actions.userArea.userEdit;

import java.util.List;

import com.assignment3.actions.BaseAction;
import com.assignment3.interfaces.LoggedIn;
import com.assignment3.miscellaneous.DatabaseUtil;
import com.assignment3.models.Course;
import com.assignment3.models.User;

public class RemoveCourseByAdminAction extends BaseAction implements LoggedIn{
	
	private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String execute() {
		DatabaseUtil.getInstance().remove(selected_course);
		setUsers(DatabaseUtil.getInstance().getAll(User.class));
		removeUserWithCourse(selected_course);
		return SUCCESS;
	}
	
	public void removeUserWithCourse(Course course) {
		for(User user : getUsers()) {
			if(user.getCourses().contains(course)) {
				user.getCourses().remove(course);
			}
		}
	}
}
