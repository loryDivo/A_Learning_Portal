package com.assignment3.actions.userArea.userEdit;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.assignment3.actions.BaseAction;
import com.assignment3.actions.userArea.WelcomeAction;
import com.assignment3.interfaces.LoggedIn;

public class DoEditBanAction extends BaseAction implements LoggedIn {
	
	private static final long serialVersionUID = 1L;
	public final static String date_format = "dd-MM-yyyy";
	
	private String ban;
	private Boolean ban_forever;
	
	public void validate() {
		if(!isRemovingBan() && isBan_forever() == false) {
			try {
	            DateFormat df = new SimpleDateFormat(date_format);
	            df.setLenient(false);
	            df.parse(ban);
	        } catch (ParseException e) {
	            addFieldError("ban", "The date must be dd-mm-yyyy");
	        }
		}
	}
	
	public String execute() {
		EditUserService service = new EditUserService(selected_user);
		service.editBan(getBan(), isBan_forever());
		
		if(isRemovingBan()) setWelcome_message(WelcomeAction.ban_user_removed);
		else setWelcome_message(WelcomeAction.ban_user);
		
		return SUCCESS;
	}

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getBan() {
		return ban;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}
	public Boolean isBan_forever() {
		return ban_forever;
	}
	public void setBan_forever(Boolean ban_forever) {
		this.ban_forever = ban_forever;
	}
	
	private boolean isRemovingBan() {
		return isBan_forever() == null && getBan() == null;
	}
	

}
