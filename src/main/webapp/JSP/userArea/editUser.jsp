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
		        		<s:hidden name="user_id" value="%{selected_user.getId()}" />
					<div class="row">
		            		<div class="col-md-6">
		            			<s:textfield key="label.edit_user_name" name="name" value="%{selected_user.getName()}" />
		            		</div>
		            		<div class="col-md-6">
		            			<s:textfield key="label.edit_user_last_name" name="last_name" value="%{selected_user.getLast_name()}" />
		            		</div>
		            </div>
		                
		            <div class="row">
		            		<div class="col-md-6">
		            			<s:textfield key="label.edit_user_city" name="city" value="%{selected_user.getCity()}" />
		                	</div>
		                	<div class="col-md-6">
		                		<s:textfield key="label.edit_user_country" name="country" value="%{selected_user.getCountry()}" />
		                	</div>
		            	</div>
		
		            <s:submit cssClass="btn btn-primary" value="Confirm Edit" />
		    		</s:form>
	    		</div>
	        <div class="col-md-3 col-md-offset-3">
	        		<s:if test="%{!admin_editing}">
			    		<s:form action="doEditPassword" enctype="multipart/form-data" theme="bootstrap" label="Edit Password">
			        		<s:hidden name="user_id" value="%{selected_user.getId()}" />
			        		
			        		<s:password key="label.edit_user_old_password" name="old_password" />
			        		<s:password key="label.edit_user_password" name="password" />
			            <s:password key="label.edit_user_password_confirm" name="password_confirm" />
			                
			        		<s:submit cssClass="btn btn-primary" value="Change Password" />
					</s:form>
				</s:if>
				<s:else>
			    		<s:form action="doEditBan" enctype="multipart/form-data" theme="bootstrap" label="Ban User">
			    			<s:hidden name="user_id" value="%{selected_user.getId()}" />
				        <s:if test="%{ban_until_message != null}">
					        <h3><s:property value="ban_until_message"/></h3>
					    		<s:submit cssClass="btn btn-danger" value="Remove Ban" />
				    		</s:if>
				    		<s:else>
				    			<s:textfield key="label.edit_user_ban" name="ban" placeholder="dd-mm-yyyy"/>
					        <s:checkbox name="ban_forever" fieldValue="true" label="Ban forever"/>
					    		<s:submit cssClass="btn btn-primary" value="Confirm Ban" />
				    		</s:else>
					</s:form>
			    	</s:else>
		    	</div>
		</div>
    </jsp:body>
</t:layout>