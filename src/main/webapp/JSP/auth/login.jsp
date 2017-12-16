<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<t:layout>
	<jsp:attribute name="title">| Login</jsp:attribute>
    <jsp:body>
    		<div class="row">
    			<div class="col-md-4 col-md-offset-4">
	    			<s:form action="doLogin" enctype="multipart/form-data" theme="bootstrap" label="Login">
	                <s:textfield key="label.login_username" name="username"/>
	
	                <s:password key="label.login_password" name="password"/>
	
	                <s:submit cssClass="btn btn-primary" value="Sign in"/>
	            </s:form>
    			</div>
    		</div>
    </jsp:body>
</t:layout>