<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="partials" tagdir="/WEB-INF/tags/partials/welcome" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<t:layout>
	<jsp:attribute name="title">| Reserved Area</jsp:attribute>
    <jsp:body>
    
    		<s:if test="%{user.isAdmin()}">
        		
        		<partials:admin />
        		
        	</s:if>
		<s:else>
		
			<partials:user />
			
		</s:else>
    </jsp:body>
</t:layout>