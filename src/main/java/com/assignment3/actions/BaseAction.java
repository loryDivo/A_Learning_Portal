package com.assignment3.actions;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.assignment3.models.Course;
import com.assignment3.models.User;

import com.assignment3.models.helpers.CourseHelper;

import com.assignment3.models.helpers.UsersHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public abstract class BaseAction extends ActionSupport implements SessionAware, Preparable {
	
	private static final long serialVersionUID = 1L;
	
	protected Map<String, Object> session;
	private int edit_action;
	//We set this variables here because for the most of the action those one will be used
	protected User user;
	protected String user_id;
	protected User selected_user;
	protected User edit_user;
	protected boolean admin_editing = false;
	protected String course_id;
	protected Course selected_course;
	
	public int getEdit_action() {
		return edit_action;
	}
	public void setEdit_action(int edit_action) {
		this.edit_action = edit_action;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public User getSelected_user() {
		return selected_user;
	}
	public void setSelected_user(User selected_user) {
		this.selected_user = selected_user;
	}
	public User getEdit_user() {
		return edit_user;
	}
	public void setEdit_user(User edit_user) {
		this.edit_user = edit_user;
	}
	public boolean isAdmin_editing() {
		return admin_editing;
	}
	public void setAdmin_editing(boolean admin_editing) {
		this.admin_editing = admin_editing;
	}
	public Course getSelected_course() {
		return selected_course;
	}
	public void setSelected_course(Course selected_course) {
		this.selected_course = selected_course;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void prepare() throws Exception {
		//set the session user for the next action and to be used by jsp pages
		User logged_user = UsersHelper.getLoggedUser(session);
		setUser(logged_user);
		setSelectedUserById();
		setSelectedCourseById();
	}
	
	public void setSelectedCourseById() {
		ActionContext context = ActionContext.getContext();
		Course selected_course = CourseHelper.getCourseFromUrlId(context);
		setSelected_course(selected_course);
	}
	
	public void setSelectedUserById() {
		//set the user passed in the url to be used during admin actions
		UsersHelper uHelper = new UsersHelper(user);
		ActionContext context = ActionContext.getContext();
		User selected_user = uHelper.getUserFromUrlId(context);
		setSelected_user(selected_user);
	}
	
	public void setEditUserOnExecute() {
		setEdit_user(user);
		if(getSelected_user() != null) {
			setEdit_user(selected_user);
			setAdmin_editing(true);
		}
	}
	
	
}
