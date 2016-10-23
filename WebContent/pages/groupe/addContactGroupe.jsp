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
		ArrayList<Contact> lesContacts = (ArrayList)request.getAttribute("lesContacts");
		ArrayList<Contact> lesMembres = (ArrayList)request.getAttribute("lesMembres");
	%>
		<div class="row">
			<div class="col-md-offset-2 col-md-6">
			<bean:message key ="contact_groupe.ajouter"/>
				<html:form styleClass="form-horizontal" action="/AddContactGroupe" method="post">
					<html:errors />
						<%
							for(Contact c : lesContacts)
							{
								String id = String.valueOf(c.getIdContact());
						%> 
								<html:multibox property ="ids" value ="<%= id %>"/><%= c.getFirstName() + " " + c.getLastName() %>
								<br>
						<%
							}
						%>
						<html:hidden property = "id" value = '<%= request.getParameter("id") %>' />
						<html:submit styleClass="btn btn-primary validerForm" value ="Valider"></html:submit>
				</html:form>
			</div>
		</div>
	</body>
   </html:html>

