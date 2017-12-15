package com.assignment3.actions.auth;

import org.apache.struts2.interceptor.SessionAware;

import com.assignment3.actions.BaseAction;
import com.assignment3.miscellaneous.DatabaseUtil;
import com.assignment3.models.User;
import com.assignment3.models.helpers.UsersHelper;

public class DoSignUpAction extends BaseAction implements SessionAware {
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String password_confirm;
	private String name;
	private String last_name;
	private String email;
	private String email_confirm;
	
	public void validate() {
		if(getUsername().isEmpty()) addFieldError("username", "Please insert a valid username");
		else if(!UsersHelper.isUniqueUsername(getUsername())) addFieldError("username", "Username already taken");
		if(getPassword().isEmpty()) addFieldError("password", "Please insert a valid password");
		else if(!UsersHelper.isStrongPassword(getPassword())) addFieldError("password", "Please insert a stronger password");
		if(!getPassword().equals(getPassword_confirm())) {
			addFieldError("password", "Password must match");
			addFieldError("password_confirm", "Password must match");
		}
		if(getName().isEmpty()) addFieldError("name", "Inser a valid name");
		if(getLast_name().isEmpty()) addFieldError("last_name", "Inser a valid last name");
		
		if(getEmail().isEmpty()) addFieldError("email", "Inser a valid email");
		else if(!UsersHelper.isValidEmail(getEmail())) addFieldError("email", "Email not valid");
		else if(!UsersHelper.isUniqueEmail(getEmail())) addFieldError("email", "Email already used");
		if(!getEmail().equals(getEmail_confirm())) {
			addFieldError("email", "Email must match");
			addFieldError("email_confirm", "Email must match");
		}
	}
	
	public String execute() {
		SignUpService.createNewUser(getUsername(), getPassword(), getName(), getLast_name(), getEmail());

		int id = DatabaseUtil.getInstance().findByField(User.class, "username", getUsername()).getId();
		boolean send = true;
		//normally it would be required the email confirmation, but for this project the user will be signed up immediately
		/*if(SignUpService.sendEmail(user)) return true;
		else return false;*/
		
		if(send) {
			LoginService.saveUserIntoSession(id, session);
			return SUCCESS;
		} else return ERROR;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword_confirm() {
		return password_confirm;
	}
	public void setPassword_confirm(String password_confirm) {
		this.password_confirm = password_confirm;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail_confirm() {
		return email_confirm;
	}
	public void setEmail_confirm(String email_confirm) {
		this.email_confirm = email_confirm;
	}
}
