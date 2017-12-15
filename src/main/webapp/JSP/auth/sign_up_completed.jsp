<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<t:layout>
	<jsp:attribute name="title">| Sign Up Completed</jsp:attribute>
    <jsp:body>
        <div class="row">
        		<div class="col-md-4 col-md-offset-4 text-center">
        			<div style="width:300px;height:300px;background-image: url('${pageContext.request.contextPath}/assets/sign_up_completed.jpg');background-size:100% 100%;"></div>
        		</div>
        </div>
        <div class="row">
        		<div class="col-md-4 col-md-offset-4 text-center">
        			<h2>Thank you for signing in. You can now access to you account.</h2>
        			<a href="welcome">
        				<button class="btn btn-success" >Go to my account</button>
        			</a>
        		</div>
        </div>
    </jsp:body>
</t:layout>