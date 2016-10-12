<%@page import="domain.DAOContact"%>
<%@page import="models.Contact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<jsp:include page="entete.jsp"></jsp:include>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>


	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><bean:message key = "title.maj.contact"/></title>
	</head>
	<body>
	
<%
	DAOContact daoc = new DAOContact();
	int id = Integer.valueOf(request.getParameter("id")); 
	Contact c = daoc.getContact(id);
	String sid = String.valueOf(id);
%>	
		<div class="row">
			<div class="col-md-offset-2 col-md-6">
				<html:form styleClass="form-horizontal" action="/UpdateContact" method ="post">
					<fieldset>
						<h1 class="formName col-md-offset-4"><bean:message key = "maj.contact"/></h1>
						<div class="form-group">
							<label class="col-md-4 control-label">Id</label>
							<div class="col-md-8">
								<html:text styleClass="form-control inputForm" property="id" value ='<%= sid %>' readonly="readonly"/>
							</div>
							<label class="col-md-4 control-label">Nom</label>
							<div class="col-md-8">
								<html:text styleClass="form-control inputForm" property = "lastName" value = '<%= c.getNom() %>'/>
							</div>
							<label class="col-md-4 control-label">Prenom</label>
							<div class="col-md-8">
								<html:text styleClass="form-control inputForm" property = "firstName" value = '<%= c.getPrenom() %>'/>
							</div>
							<label class="col-md-4 control-label">Mail</label>
							<div class="col-md-8">
								<html:text styleClass="form-control inputForm" property = "email" value = '<%= c.getEmail() %>'/>
							</div>
		
							<div class="col-md-offset-7">
								<html:submit styleClass="btn btn-primary validerForm" value="Valider" />
							</div>
						</div>
					</fieldset>
				</html:form>
			</div>
		</div>		
	</body>
</html:html>