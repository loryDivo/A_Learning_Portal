<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<t:layout>
	<jsp:attribute name="title">| Sign Up</jsp:attribute>
    <jsp:body>
        <s:form action="doSignUp" enctype="multipart/form-data" theme="bootstrap" label="Sign Up">
                <s:textfield key = "label.sign_up_username" name="username"/>
                
                <div class="row">
                		<div class="col-md-6">
                			<s:password key = "label.sign_up_password" name="password"/>
                		</div>
                		<div class="col-md-6">
                			<s:password key = "label.sign_up_password_confirm" name="password_confirm"/>
                		</div>
                </div>
                
                <div class="row">
                		<div class="col-md-6">
                			<s:textfield key = "label.sign_up_name" name="name"/>
                		</div>
                		<div class="col-md-6">
                			<s:textfield key = "label.sign_up_last_name" name="last_name"/>
                		</div>
                </div>
               
               <div class="row">
                		<div class="col-md-6">
                			<s:textfield key = "label.sign_up_email" name="email"/>
                		</div>
                		<div class="col-md-6">
                			<s:textfield key = "label.sign_up_email_confirm" name="email_confirm"/>
                		</div>
                </div>

                <s:submit cssClass="btn btn-primary" value="Sign Up"/>
            </s:form>
    </jsp:body>
</t:layout>