package com.assignment3.actions.userArea.userEdit;

import com.assignment3.actions.BaseAction;
import com.assignment3.actions.userArea.WelcomeAction;
import com.assignment3.interfaces.LoggedIn;
import com.assignment3.miscellaneous.DatabaseUtil;

public class DoRemoveCourseToUserAction extends BaseAction implements LoggedIn {

	private static final long serialVersionUID = 1L;
	
	public String execute() {
		// if the selected course is null it means that the user has changed the url.
		// Return anyway success, due the bad behavior of the user
		if (getSelected_course() != null) {
			// no need for a service
			user.getCourses().remove(selected_course);
			selected_course.getUsers().remove(user);
			DatabaseUtil.getInstance().save(user);
			DatabaseUtil.getInstance().save(selected_course);
		}

		setWelcome_message(WelcomeAction.course_remove);
		return SUCCESS;
	}

}
