<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<li class="dropdown">
	<a href="#" class="dropdown-toggle" data-toggle="dropdown"> <span class="glyphicon glyphicon-user"></span> 
		<strong><s:property value="%{user.username}"></s:property></strong> <span class="glyphicon glyphicon-chevron-down"></span>
	</a>
	<ul class="dropdown-menu">
		<li>
			<div class="navbar-login">
				<div class="row">
					<div class="col-lg-4">
						<a href="welcome" class="text-center"> <span
							class="glyphicon glyphicon-user icon-size"></span>
						</a>
					</div>
					<div class="col-lg-8">
						<p class="text-left">
							<strong><s:property value="%{user.name}" /> <s:property value="%{user.last_name}"/></strong>
						</p>
						<p class="text-left small"><s:property value="%{user.email}"></s:property></p>
						<p class="text-left">
							<a href="edit-user" class="btn btn-primary btn-block btn-sm">Manage Account</a>
						</p>
					</div>
				</div>
			</div>
		</li>
		<li class="divider"></li>
		<li>
			<div class="navbar-login navbar-login-session">
				<div class="row">
					<div class="col-lg-12">
						<p>
							<a href="logout" class="btn btn-danger btn-block">Logout</a>
						</p>
					</div>
				</div>
			</div>
		</li>
	</ul>
</li>
