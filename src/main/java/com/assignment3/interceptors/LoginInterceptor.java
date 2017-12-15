package com.assignment3.interceptors;

import java.util.Map;

import com.assignment3.actions.auth.LoginAction;
import com.assignment3.interfaces.LoggedAdmin;
import com.assignment3.interfaces.LoggedIn;
import com.assignment3.interfaces.NotLoggedIn;
import com.assignment3.models.User;
import com.assignment3.models.helpers.UsersHelper;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor {
	
	private static final long serialVersionUID = 1L;

	@Override
    public String intercept(final ActionInvocation invocation) throws Exception {
		
        Map<String, Object> session = ActionContext.getContext().getSession();

        Integer userId = (Integer) session.get("userId");
        
        Object action = invocation.getAction();

        if (userId != null) {
        		if (action instanceof NotLoggedIn) return "welcomeRedirect";
        		else if (action instanceof LoggedAdmin) {
        			User user = UsersHelper.getLoggedUser(session);
        			if(!user.isAdmin()) return "welcomeRedirect";
        		} else return invocation.invoke();
        }

        if (!(action instanceof LoggedIn)) {
            return invocation.invoke();
        }

        if (!(action instanceof LoginAction)) {
            return "loginRedirect";
        }

        return invocation.invoke();
    }
}
