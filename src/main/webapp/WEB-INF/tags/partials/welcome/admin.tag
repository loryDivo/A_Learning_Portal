<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<c:forEach items="${User.getAll()}" var="user">
				<c:if test = "${!user.isAdmin()}">
					<tr>
						<td><c:out value="${user.getUsername()}" /></td>
						<td><c:out value="${user.getLast_name()}" /></td>
						<td><c:out value="${user.getEmail()}" /></td>
						<td><a class="btn btn-info" href="edit-user">Manage</a></td>
						<td><button type="button" class="btn btn-info">Ban</button></td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>

</div>

