<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
    <jsp:body>
        <div class="row">
        		<div class="col-md-12">
        			<div style="width:100%;height:300px;background-image: url('${pageContext.request.contextPath}/assets/index.jpg');background-size:100% 100%;"></div>
        		</div>
        </div>
        <div class="row">
        		<div class="col-md-12 text-center">
        			<h1 style="margin: 100px auto;">The way to manage your study.</h1>
        			<a href="login">
        				<button class="btn btn-info" >Go to my account</button>
        			</a>
        		</div>
        </div>
    </jsp:body>
</t:layout>