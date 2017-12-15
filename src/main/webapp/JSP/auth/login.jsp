<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<t:layout>
	<jsp:attribute name="title">| Login</jsp:attribute>
    <jsp:body>
        <s:form action="doLogin" enctype="multipart/form-data" theme="bootstrap" label="Login">
                <s:textfield label="Username" name="username"/>

                <s:password label="Password" name="password"/>

                <s:submit cssClass="btn btn-primary" value="Log in"/>
            </s:form>
    </jsp:body>
</t:layout>