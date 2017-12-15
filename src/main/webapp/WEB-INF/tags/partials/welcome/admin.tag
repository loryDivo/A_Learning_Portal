<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="container">
	<h2>Admin sign-in</h2>
	<p>The table cointain user sign-in</p>
	<table class="table">
		<thead>
			<tr>
				<th>Username</th>
				<th>Firstname</th>
				<th>Lastname</th>
				<th>Email</th>
				<td>Manage</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<c:if test="${!user.isAdmin()}">
					<tr>
						<td><c:out value="${user.getUsername()}" /></td>
						<td><c:out value="${user.getName()}" /></td>
						<td><c:out value="${user.getLast_name()}" /></td>
						<td><c:out value="${user.getEmail()}" /></td>
						<td><a href="edit-user?user_id=${user.getId()}">
								<button type="button" class="btn btn-info">Manage</button>
						</a></td>
						<c:if test="${user.getBan_until() != null }">
							<td><a href="doEditBan?user_id=${user.getId()}">
									<button type="button" class="btn btn-danger">Remove
										Ban</button>
							</a></td>
						</c:if>
				</c:if>
			</c:forEach>
	</table>
	<p>The table cointain courses</p>
	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>CFU</th>
			</tr>
		</thead>
		</tbody>
		<tbody>
			<c:forEach items="${courses}" var="course">
				<tr>
					<td><c:out value="${course.getName()}" /></td>
					<td><c:out value="${course.getCFU()}" /></td>
					<td><a href="doEditCourseByAdmin?course_id=${course.getId()}&user_id${user.getId()}">
							<button type="button" class="btn btn-info">Manage</a>
					<a href="removeCourseByAdmin?course_id=${course.getId()}">
							<button type="button" class="btn btn-info">Remove</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a class="btn btn-primary" href="doEditCourse" role="button">Add
		course</a>
</div>

