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
					<td><a class="btn btn-primary" href="removeCourseByUser?user_id=${user.getId()}&course_id=${course.getId()}" role="button">Remove</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
    <div class="dropdown">
        <a class="btn btn-primary dropdown-toggle"  id = "botton_add_course" type="button" data-toggle="dropdown">Add course
    		<span class="caret"></span></a>
        <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
            <c:forEach items="${remaining_courses}" var="course">
					<li><a
						href="<c:url value='addCourseByUser?user_id=${user.getId()}&course_id=${course.getId()}'/>"><c:out
								value="${course.getName()}" /></a></li>
			</c:forEach>
        </ul>
    </div>
</div>