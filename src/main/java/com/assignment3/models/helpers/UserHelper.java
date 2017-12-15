package com.assignment3.models.helpers;

import java.util.Map;

import org.apache.struts2.dispatcher.Parameter;

import com.assignment3.miscellaneous.DatabaseUtil;
import com.assignment3.models.User;
import com.opensymphony.xwork2.ActionContext;

public class UserHelper {
	
	private static final String user_id_url_param_name = "user_id";
	private User user;
	
	public UserHelper(User user) {
		this.user = user;
	}
	
	public User getUserFromUrlId(ActionContext context) {
		Map<String, Parameter> params = context.getParameters();
		String id = params.get(user_id_url_param_name).getValue();
		if(id != null && !id.isEmpty() && user.isAdmin()) {
			Integer u_id = Integer.parseInt(id);
			//if the selected_user and the user are the same, avoid to set selected user
			if(user.getId() != u_id) 
				return DatabaseUtil.getInstance().find(User.class, u_id);
		}
		return null;
	}
	
	public boolean checkPassword(String password) {
		PasswordHelper pswHerlper = new PasswordHelper();
		return pswHerlper.authenticate(password.toCharArray(), user.getPassword()); 
	}
	
	public static String getHashedPassword(String password) {
		PasswordHelper pswHerlper = new PasswordHelper();
		return pswHerlper.hash(password.toCharArray());
	}
	
	public static boolean isUniqueUsername(String username) {
		return DatabaseUtil.getInstance().findByField(User.class, "username", username) == null;
	}
	public static boolean isStrongPassword(String password) {
		return true;
	}
	public static boolean isValidEmail(String email) {
		return true;
	}
	public static boolean isUniqueEmail(String email) {
		return DatabaseUtil.getInstance().findByField(User.class, "email", email) == null;
	}
	
	public static User getLoggedUser(Map<String, Object> session) {
		Integer id = (Integer)session.get("userId");
		if(id != null) 
			return DatabaseUtil.getInstance().find(User.class, id);
		
		return null;
	}
}
