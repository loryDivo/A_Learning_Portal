<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<t:layout>
	<jsp:attribute name="title">| Sign Up Error</jsp:attribute>
    <jsp:body>
         <div class="row">
        		<div class="col-md-4 col-md-offset-4 text-center">
        			<div style="width:300px;height:300px;background-image: url('${pageContext.request.contextPath}/assets/sign_up_error.png');background-size:100% 100%;"></div>
        		</div>
        </div>
        <div class="row">
        		<div class="col-md-4 col-md-offset-4 text-center">
        			<h2>There was an error during your sign in. <br>Please, retry.<br>If the problem persists, contact us to tell the situation.</h2>
        			<a href="index">
        				<button class="btn btn-danger" >Go to home page</button>
        			</a>
        		</div>
        </div>
    </jsp:body>
</t:layout>