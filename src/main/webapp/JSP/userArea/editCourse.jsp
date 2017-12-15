<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="partials" tagdir="/WEB-INF/tags/partials/welcome"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<t:layout>
	<jsp:attribute name="title">| Edit User</jsp:attribute>
	<jsp:body>
    		<div class="row">
            <div class="col-md-6">
		        <s:form action="editCourseByAdmin"
					enctype="multipart/form-data" theme="bootstrap" label="Edit Data">
		        		<s:hidden name="course_id" value="%{selected_course.getId()}" />
					<div class="row">
		            		<div class="col-md-6">
		            			<s:textfield label="Name" name="name"
								value="%{selected_course.getName()}" />
		            		</div>
		            		<div class="col-md-6">
		            			<s:textfield label="CFU" name="cfu"
								value="%{selected_course.getCFU()}" />
		            		</div>
		            </div>
		
		            <s:submit cssClass="btn btn-primary" />
		    		</s:form>
	    		</div>
	    	</div>
	</jsp:body>
</t:layout>
