<%@ tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="navbar" tagdir="/WEB-INF/tags/partials/layout/navbar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>


<div id="pageheader">
	<nav class="navbar">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="index">Assignment 3</a>
			</div>
			<s:if test="%{user != null}">
				<ul class="nav navbar-nav">
					<li class="active"><a href="welcome">Home</a></li>
				</ul>
			</s:if>
			<ul class="nav navbar-nav navbar-right">
				<s:if test="%{user == null}">
					<li><a href="sign-up"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
					<li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
				</s:if>
				<s:else>
					<navbar:user_dropdown />
				</s:else>
			</ul>
		</div>
	</nav>
</div>
