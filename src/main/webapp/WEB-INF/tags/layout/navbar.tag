<%@ tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@taglib prefix="navbar" tagdir="/WEB-INF/tags/layout/navbar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="pageheader">
	<nav class="navbar">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="index">Assignment 3</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">Page 1</a></li>
				<li><a href="#">Page 2</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${empty user}">
						<li><a href="#"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
						<li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</c:when>
					<c:otherwise>
						<navbar:user_dropdown />
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</nav>
</div>
