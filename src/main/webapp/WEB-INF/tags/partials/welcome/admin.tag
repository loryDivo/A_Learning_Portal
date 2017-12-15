<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					<c:if test="${user.isBanned()}">
						<td>
							<a href="doEditBan?user_id=${user.getId()}">
								<button type="button" class="btn btn-danger">Remove Ban</button>
							</a>
						</td>
					</c:if>
			</c:forEach>
		</tbody>
	</table>

</div>

