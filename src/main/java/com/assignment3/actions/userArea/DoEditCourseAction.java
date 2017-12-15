package com.assignment3.actions.userArea;

import com.assignment3.actions.BaseAction;
import com.assignment3.interfaces.LoggedIn;

public class DoEditCourseAction extends BaseAction implements LoggedIn{

	private static final long serialVersionUID = 1L;

	public String execute(){
		return SUCCESS;
	}
}
