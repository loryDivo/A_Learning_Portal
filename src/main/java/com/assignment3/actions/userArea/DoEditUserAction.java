package com.assignment3.actions.userArea;

import com.assignment3.actions.BaseAction;
import com.assignment3.actions.LoggedIn;

public class DoEditUserAction extends BaseAction implements LoggedIn {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String last_name;
	private String city;
	private String country;
	
	public void validate() {
		if(getName().isEmpty()) addFieldError("name", "Please insert a valid name");
		if(getLast_name().isEmpty()) addFieldError("last_name", "Please insert a valid last name");
	}
	
	public String execute() {
		EditUserService service = new EditUserService(user);
		service.editUser(getName(), getLast_name(), getCity(), getCountry());
		return SUCCESS;
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
	
	

}
