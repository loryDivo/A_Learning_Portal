package com.assignment3.models.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.dispatcher.Parameter;

import com.assignment3.actions.userArea.userEdit.EditUserService;
import com.assignment3.miscellaneous.DatabaseUtil;
import com.assignment3.models.User;
import com.opensymphony.xwork2.ActionContext;

public class UsersHelper {
	
	private static final String user_id_url_param_name = "user_id";
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	private User user;
	
	public UsersHelper(User user) {
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
	
	public String getBanMessage() {
		if (user.isBanned()) {
			Date ban_until = user.getBan_until();

			SimpleDateFormat dt = new SimpleDateFormat("dd MMMM yyyy");
			String message = "until " + dt.format(ban_until);

			// get the correct format for compare the date to the forever date
			SimpleDateFormat dtForever = new SimpleDateFormat(EditUserService.ban_forever_date_format);
			if (dtForever.format(ban_until).equals(EditUserService.ban_forever_date)) message = "Forever";

			return message;
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
		return PasswordHelper.isPasswordIsStrong(password);
	}
	public static boolean isValidEmail(String email) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
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
