<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="partials" tagdir="/WEB-INF/tags/partials/welcome"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<t:layout>
	<jsp:attribute name="title">| Edit User</jsp:attribute>
	<jsp:body>
    		<div class="row">
            <div class="col-md-6">
		        <s:form action="doEditUser" enctype="multipart/form-data" theme="bootstrap" label="Edit Data">
		        		<s:hidden name="user_id" value="%{edit_user.getId()}" />
					<div class="row">
		            		<div class="col-md-6">
		            			<s:textfield label="Name" name="name" value="%{edit_user.getName()}" />
		            		</div>
		            		<div class="col-md-6">
		            			<s:textfield label="Last Name" name="last_name" value="%{edit_user.getLast_name()}" />
		            		</div>
		            </div>
		                
		            <div class="row">
		            		<div class="col-md-6">
		            			<s:textfield label="City" name="city" value="%{edit_user.getCity()}" />
		                	</div>
		                	<div class="col-md-6">
		                		<s:textfield label="Country" name="country" value="%{edit_user.getCountry()}" />
		                	</div>
		            	</div>
		
		            <s:submit cssClass="btn btn-primary" value="Confirm Edit" />
		    		</s:form>
	    		</div>
	        <div class="col-md-3 col-md-offset-3">
	        		<s:if test="%{!admin_editing}">
			    		<s:form action="doEditPassword" enctype="multipart/form-data" theme="bootstrap" label="Edit Password">
			        		<s:hidden name="user_id" value="%{edit_user.getId()}" />
			        		
			        		<s:password label="Old Password" name="old_password" />
			        		<s:password label="Password" name="password" />
			            <s:password label="Repeat Password" name="password_confirm" />
			                
			        		<s:submit cssClass="btn btn-primary" value="Change Password" />
					</s:form>
				</s:if>
				<s:else>
			    		<s:form action="doEditBan" enctype="multipart/form-data" theme="bootstrap" label="Ban User">
			    			<s:hidden name="user_id" value="%{edit_user.getId()}" />
				        <s:if test="%{ban_until_message != null}">
					        <h3><s:property value="ban_until_message"/></h3>
					    		<s:submit cssClass="btn btn-danger" value="Remove Ban" />
				    		</s:if>
				    		<s:else>
				    			<s:textfield label="Ban Until" name="ban" placeholder="dd-mm-yyyy"/>
					        <s:checkbox name="ban_forever" fieldValue="true" label="Ban forever"/>
					    		<s:submit cssClass="btn btn-primary" value="Confirm Ban" />
				    		</s:else>
					</s:form>
			    	</s:else>
		    	</div>
		</div>
    </jsp:body>
</t:layout>