<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Course</title>
<t:layout>
	<jsp:body>
		<s:form action="editCourse" enctype="multipart/form-data"
			theme="bootstrap" label="Create course">
                <s:textfield label="Name" name="name" />
                <div class="row">
                		<div class="col-md-6">
						<s:textfield label="CFU" name="cfu" />
					</div>
				</div>
                <s:submit cssClass="btn btn-primary" />
            </s:form>
</jsp:body>
</t:layout>