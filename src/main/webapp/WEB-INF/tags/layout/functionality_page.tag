<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<s:if test="#session.userId==2">
		<div class="container">
			<h2>User sign-in</h2>
			<p>The table cointain course of user/p>
			<table class="table">
				<thead>
					<tr>
						<th>Course name</th>
						<th>CFU</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${courseList}" var="course">
						<tr>
							<td><c:out value="${course.getName()}" /></td>
							<td><c:out value="${course.getCFU()}" /></td>
							<td><button type="button" class="btn btn-info">Manage</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</s:if>
	<s:else>
		<div class="container">
			<h2>Admin sign-in</h2>
			<p>The table cointain user sign-in</p>
			<table class="table">
				<thead>
					<tr>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Email</th>
						<td>Manage</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userList}" var="user">
						<tr>
							<td><c:out value="${user.getUsername()}" /></td>
							<td><c:out value="${user.getLast_name()}" /></td>
							<td><c:out value="${user.getEmail()}" /></td>
							<td><button type="button" class="btn btn-info">Manage</button></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</s:else>