<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<t:layout>
	<jsp:attribute name="title">| Reserved Area Admin</jsp:attribute>
    <jsp:body>
        <p>
        		<s:property value="%{user.username}"></s:property>
        </p><br/>
    </jsp:body>
</t:layout>