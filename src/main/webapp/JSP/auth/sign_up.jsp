<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<t:layout>
	<jsp:attribute name="title">| Sign Up</jsp:attribute>
    <jsp:body>
        <s:form action="doSignUp" enctype="multipart/form-data" theme="bootstrap" label="Sign Up">
                <s:textfield label="Username" name="username"/>
                
                <div class="row">
                		<div class="col-md-6">
                			<s:password label="Password" name="password"/>
                		</div>
                		<div class="col-md-6">
                			<s:password label="Repeat Password" name="password_confirm"/>
                		</div>
                </div>
                
                <div class="row">
                		<div class="col-md-6">
                			<s:textfield label="Name" name="name"/>
                		</div>
                		<div class="col-md-6">
                			<s:textfield label="Last Name" name="last_name"/>
                		</div>
                </div>
               
               <div class="row">
                		<div class="col-md-6">
                			<s:textfield label="Email" name="email"/>
                		</div>
                		<div class="col-md-6">
                			<s:textfield label="Email" name="email_confirm"/>
                		</div>
                </div>

                <s:submit cssClass="btn btn-primary"/>
            </s:form>
    </jsp:body>
</t:layout>