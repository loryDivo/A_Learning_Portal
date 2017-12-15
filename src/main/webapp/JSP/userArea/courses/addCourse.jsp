<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="partials" tagdir="/WEB-INF/tags/partials/welcome"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<t:layout>
	<jsp:attribute name="title">| Add Course</jsp:attribute>
	<jsp:body>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<s:form action="doAddCourse" enctype="multipart/form-data" theme="bootstrap" label="Create course">
	                <s:textfield label="Name" name="name" />
					<s:textfield label="CFU" name="cfu" />
	                <s:submit cssClass="btn btn-primary" value="Add" />
            		</s:form>
			</div>
		</div>
	</jsp:body>
</t:layout>