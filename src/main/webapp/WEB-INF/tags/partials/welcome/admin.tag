<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div class="container">
	<h2>Admin sign-in</h2>
	<p style="margin: 50px 0px 0px 0px;">The table contains user sign-in</p>
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
						<td>
							<a href="edit-user?user_id=${user.getId()}">
								<button type="button" class="btn btn-info">Manage</button>
							</a>
						</td>
						<c:if test="${user.getBan_until() != null }">
							<td>
								<a href="doEditBan?user_id=${user.getId()}">
									<button type="button" class="btn btn-danger">Remove Ban</button>
								</a>
							</td>
						</c:if>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
	<span style="margin: 50px 0px 0px 0px;">The table contains courses</span>
	<a class="btn btn-primary" style="margin-left: 25px;" href="add-course" role="button">Add course</a>
	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>CFU</th>
				<th>Users</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${courses}" var="course">
				<tr>
					<td><c:out value="${course.getName()}" /></td>
					<td><c:out value="${course.getCFU()}" /></td>
					<td>
						<c:choose>
							<c:when test="${course.getUsers().size() > 0}">
								<a href="show-course?course_id=${course.getId()}">
									<c:out value="${course.getUsers().size()} users" />
								</a>
							</c:when>
							<c:otherwise>
								<c:out value="${course.getUsers().size()} users" />
							</c:otherwise>
						</c:choose>
					</td>
					<td></td>
					<td>
						<a href="edit-course?course_id=${course.getId()}">
							<button type="button" class="btn btn-info">Edit</button>
						</a>
					</td>
					<td>
						<a href="removeCourseByAdmin?course_id=${course.getId()}">
							<button type="button" class="btn btn-danger">Remove</button>
						</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

