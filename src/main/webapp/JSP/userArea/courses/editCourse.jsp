<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="partials" tagdir="/WEB-INF/tags/partials/welcome"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<t:layout>
	<jsp:attribute name="title">| Edit Course</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<s:form action="doEditCourse" enctype="multipart/form-data" theme="bootstrap" label="Edit course">
					<s:hidden name="course_id" value="%{selected_course.getId()}" />
	                <s:textfield key = "label.edit_course_name" name="name" value="%{selected_course.getName()}" />
					<s:textfield key = "label.edit_course_cfu" name="cfu" value="%{selected_course.getCFU()}"/>
	                <s:submit cssClass="btn btn-primary" value="Edit" />
            		</s:form>
			</div>
		</div>
	</jsp:body>
</t:layout>