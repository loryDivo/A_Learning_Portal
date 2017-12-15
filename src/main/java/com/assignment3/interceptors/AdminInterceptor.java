package com.assignment3.interceptors;

import java.util.Map;

import com.assignment3.actions.userArea.userEdit.DoEditBanAction;
import com.assignment3.models.User;
import com.assignment3.models.helpers.UserHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminInterceptor extends AbstractInterceptor {
	
	private static final long serialVersionUID = 1L;
	
	private static final String welcomeRedirect = "welcomeRedirect";

	@Override
    public String intercept(final ActionInvocation invocation) throws Exception {
		
		ActionContext context = ActionContext.getContext();
		
		//check if the id passed is OK. Otherwise, redirect to welcome page, because the user must have changed the url or something in the code 
		Map<String, Object> session = context.getSession();
		
		Object action = invocation.getAction();
		
		User logged_user = UserHelper.getLoggedUser(session);
		
		if(action instanceof DoEditBanAction) {
			//If is ban action, the user must be the admin
			if(!logged_user.isAdmin()) return welcomeRedirect;
			
			//In ban action the passed passed user must be present in the DB
			UserHelper uHelper = new UserHelper(logged_user); 
			User selected_user = uHelper.getUserFromUrlId(context);
			if(selected_user == null) return welcomeRedirect;
		}
		
        return invocation.invoke();
    }
	
}
