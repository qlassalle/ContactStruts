<%@page import="domain.DAOContact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@page import="java.util.ArrayList" %>
<%@page import="models.Contact" %>
<%@page import="domain.DAOContact" %>

<jsp:include page="../entete.jsp"></jsp:include>
  
   <html:html>

   <head>

   <title><bean:message key="contact_groupe.ajouter"/></title>

   <html:base/>

   </head>

   <body bgcolor="white">
	
	<% 
		ArrayList<Contact> lesContacts = (ArrayList<Contact>)request.getAttribute("lesContacts");
		ArrayList<Contact> lesMembres = (ArrayList<Contact>)request.getAttribute("lesMembres");
	%>
		<div class="row">
			<div class="col-md-offset-4 col-md-6 ajoutContactGroupe">
				<h1><bean:message key ="contact_groupe.ajouter"/></h1>
				<div class="row">
					<div class="col-md-offset-3">
						<html:form styleClass="form-horizontal" action="/AddContactGroupe" method="post">
							<html:errors />
							<fieldset>
								<%
									for(Contact c : lesContacts)
									{
										String id = String.valueOf(c.getIdContact());
								%> 
										<div class="contactCheckbox">
											<html:multibox styleClass = "contactCheckbox" property ="ids" value ="<%= id %>"/><%= c.getFirstName() + " " + c.getLastName() %>
											<br>
										</div>
								<%
									}
								%>
								<html:hidden property = "id" value = '<%= request.getParameter("id") %>' />
								<html:submit styleClass="btn btn-primary validerForm" value ="Valider"></html:submit>
							</fieldset>
						</html:form>
					</div>
				</div>
			</div>
		</div>
	</body>
   </html:html>