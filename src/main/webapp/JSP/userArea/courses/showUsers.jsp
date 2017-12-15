<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="partials" tagdir="/WEB-INF/tags/partials/welcome"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:layout>
	<jsp:attribute name="title">| Show Course's Users</jsp:attribute>
	<jsp:body>
		<h4>Showing users of course: <s:property value="%{selected_course.getName()}"/></h4>
		<table class="table">
			<thead>
				<tr>
					<th>Username</th>
					<th>Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><c:out value="${user.getUsername()}" /></td>
						<td><c:out value="${user.getName()}" /></td>
						<td><c:out value="${user.getLast_name()}" /></td>
						<td><c:out value="${user.getEmail()}" /></td>
						<td>
							<a href="doRemoveUserToCourse?user_id=${user.getId()}&course_id=${selected_course.getId()}">
								<button type="button" class="btn btn-danger">Remove</button>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</jsp:body>
</t:layout>