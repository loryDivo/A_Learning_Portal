package com.assignment3.actions.userArea.userEdit;

import com.assignment3.actions.BaseAction;
import com.assignment3.actions.userArea.WelcomeAction;
import com.assignment3.interfaces.LoggedIn;
import com.assignment3.models.User;

public class DoEditUserAction extends BaseAction implements LoggedIn {

	private static final long serialVersionUID = 1L;
	
	private String user_id;
	private String name;
	private String last_name;
	private String city;
	private String country;
	
	private int edit_action;
	
	public void validate() {
		if(getName().isEmpty()) addFieldError("name", "Please insert a valid name");
		if(getLast_name().isEmpty()) addFieldError("last_name", "Please insert a valid last name");
	}
	
	public String execute() {
		User edit_user = user;
		//if the selected user is not null, the admin is trying to edit a user. Otherwise, user is editing himself
		if(getSelected_user() != null) edit_user = selected_user;
		
		EditUserService service = new EditUserService(edit_user);
		service.editUser(getName(), getLast_name(), getCity(), getCountry());
		
		setEdit_action(WelcomeAction.edit_user);
		return SUCCESS;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getEdit_action() {
		return edit_action;
	}
	public void setEdit_action(int edit_action) {
		this.edit_action = edit_action;
	}
}
