<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<h2>User sign-in</h2>
	<p>The table cointain course of user</p>
	<table class="table">
		<thead>
			<tr>
				<th>Course name</th>
				<th>CFU</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${user.getCourses()}" var="course">
				<tr>
					<td><c:out value="${course.getName()}" /></td>
					<td><c:out value="${course.getCFU()}" /></td>
					<td><button type="button" class="btn btn-info">Manage</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a class="btn btn-primary" href="doEditCourse" role="button">Add course</a>
</div>