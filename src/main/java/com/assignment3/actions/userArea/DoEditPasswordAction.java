package com.assignment3.actions.userArea;

import com.assignment3.actions.BaseAction;
import com.assignment3.actions.LoggedIn;
import com.assignment3.actions.auth.SignUpService;

public class DoEditPasswordAction extends BaseAction implements LoggedIn {

	private static final long serialVersionUID = 1L;
	private String old_password;
	private String password;
	private String password_confirm;
	
	private EditUserService service;
	
	public void validate() {
		service = new EditUserService(user);
		
		if(getOld_password().isEmpty()) addFieldError("old_password", "Old password required");
		else if(!service.oldPasswordCorrect(getOld_password())) addFieldError("old_password", "Old password not corrispondent");
		else if(getPassword().isEmpty()) addFieldError("password", "New password required");
		else if(!SignUpService.isStrongPassword(getPassword()))  addFieldError("password", "Please use a stronger password");
		else if(!getPassword().equals(getPassword_confirm())) {
			addFieldError("password", "Password must be the same");
			addFieldError("password_confirm", "Password must be the same");
		}
	}
	
	public String execute() {
		service.editPassword(getPassword());
		
		return SUCCESS;
	}
	
	

	public String getOld_password() {
		return old_password;
	}
	public void setOld_password(String old_password) {
		this.old_password = old_password;
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
}
