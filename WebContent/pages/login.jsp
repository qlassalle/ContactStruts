<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<jsp:include page="enteteLogin.jsp"></jsp:include>
	
	<div class="col-md-offset-4 col-md-6">
		<h1><bean:message key = "application.authentication"/></h1>
		
		<div class="col-md-6">
			<html:form styleClass="form-horizontal" method="post" action="/Login">
				<div class="form-group">
		
					<label class="col-md-4 control-label login"><bean:message	key="login.login" /></label>
					<div class="col-md-8">
						<html:text styleClass="form-control inputForm" property="name" />
					</div>
					
					<label class="col-md-4 control-label login"><bean:message	key="login.password" /></label>
					<div class="col-md-8">
						<html:password styleClass="form-control inputForm" property="password" />
					</div>
		
					<div class="col-md-offset-7">
						<html:submit styleClass="btn btn-primary validerForm" value="Valider" />
					</div>
				</div>
			</html:form>
		</div>
	</div>
</body>
</html>