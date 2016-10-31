<%@page import="services.PhoneNumberService"%>
<%@page import="services.ContactService"%>
<%@page import="domain.DAOGroupe"%>
<%@page import="domain.DAOPhoneNumber"%>
<%@page import="domain.DAOContact"%>
<%@page import="models.Contact"%>
<%@page import="models.Address"%>
<%@page import="models.PhoneNumber"%>
<%@page import="models.Groupe"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
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
	ContactService cs = new ContactService();
	int contactId;
	if(request.getParameter("idContact") != null) {
		contactId = Integer.valueOf(request.getParameter("idContact")); 
		session.setAttribute("contactId", contactId);	
	}
	else {
		try {
			contactId = ((Long)session.getAttribute("contactId")).intValue();
		} catch (ClassCastException cce) {
			contactId = (int)session.getAttribute("contactId");
		}
	}
	Contact c = cs.getContactById(contactId);
%>	
		<div class="row">
			<div class="col-md-offset-2 col-md-6">
				<html:form styleClass="form-horizontal" action="/UpdateContact" method ="post">
					<fieldset>
						<h1 class="formName col-md-offset-4"><bean:message key = "maj.contact"/></h1>
						<div class="form-group">
							<label class="col-md-4 control-label">Nom</label>
							<div class="col-md-8">
								<html:text styleClass="form-control inputForm" property = "lastName" value = '<%= c.getLastName() %>'/>
							</div>
							<label class="col-md-4 control-label">Prenom</label>
							<div class="col-md-8">
								<html:text styleClass="form-control inputForm" property = "firstName" value = '<%= c.getFirstName() %>'/>
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
<%
	Address address;
	try
	{
		address = cs.getContactAddress(contactId);
	}
	catch (NullPointerException npe)
	{
		address = null;
	}
%>		
		
		<div class="row">
			<div class="col-md-offset-2 col-md-6 contactAdresse">
				<h1 class="formName col-md-offset-4"><bean:message key = "adresse.contact"/></h1>
				<%
					if(address != null) {
				%>
					<table class = "table table-striped table-bordered col-md-offset-2">
						<thead>
							<tr>
								<th><bean:message key = "adresse.pays"/></th>
								<th><bean:message key = "adresse.zip"/></th>
								<th><bean:message key = "adresse.ville"/></th>
								<th><bean:message key = "adresse.rue"/></th>
							</tr>
						</thead>
								<tr>					
									<td><%= address.getCountry() %></td>
									<td><%= address.getZip() %></td>
									<td><%= address.getCity() %></td>
									<td><%= address.getStreet() %></td>
									<td><html:link action ="address/updateAddress.jsp">
											<html:param name="id"><%= address.getId() %></html:param>
											<span class = "glyphicon glyphicon-pencil"></span>
										</html:link>
									</td>
									<td>
									<html:link action ="/DeleteAddress">
											<html:param name = "id"><%= address.getId()%></html:param>
											<span class="glyphicon glyphicon-remove"></span>
										</html:link>
									</td>
								</tr>
					</table>					
				<%
				} else {
					%>
					<div class="col-md-offset-4">
						<html:link action="address/createAddress.jsp">
						<p class ="ajoutAttribut"><bean:message key = "creation.adresse.contact"/></p>
						</html:link>
					</div>
				<%
				}
				%>
			</div>
		</div>
		
<% 
	List<PhoneNumber> numbers;
	PhoneNumberService pns = new PhoneNumberService();
	try {
		numbers = (ArrayList<PhoneNumber>)pns.getPhoneNumbers(contactId); 
	} catch (NullPointerException npe) {
		numbers = null;
	}
%>

	<div class="row">
		<div class="col-md-offset-2 col-md-6 contactNumbers">
			<h1 class="formName col-md-offset-4">
				<bean:message key="phoneNumber.contact" />
			</h1>
			<table class="table table-striped table-bordered col-md-offset-2">
				<thead>
					<tr>
						<th><bean:message key="phoneNumber.kind" /></th>
						<th><bean:message key="phoneNumber.number" /></th>
					</tr>
				</thead>
				
				<%
					if(numbers != null) {
						for(PhoneNumber number : numbers) {
				%>
				<tr>
					<td><%= number.getKind() %></td>
					<td><%= number.getNumber() %></td>
					<td><html:link action="phoneNumber/updateNumber.jsp">
							<html:param name="id"><%= number.getId() %></html:param>
							<span class="glyphicon glyphicon-pencil"></span>
						</html:link></td>
					<td><html:link action="/DeletePhoneNumber">
							<html:param name="idPhoneNumber"><%= number.getId()%></html:param>
							<span class="glyphicon glyphicon-remove"></span>
						</html:link></td>
				</tr>
				
			<%
						}
				}
			%>
			</table>
			<div class="col-md-offset-4">
				<html:link action="phoneNumber/createPhoneNumber.jsp">
					<p class="ajoutAttribut">
						<bean:message key="creation.phoneNumber" />
					</p>
				</html:link>
			</div>
		</div>
	</div>
	
<% 
	Map<Integer, String> lesGroupes;
	try {
		lesGroupes = (HashMap<Integer, String>)cs.getGroupes(contactId); 
	} catch (NullPointerException npe) {
		lesGroupes = null;
	}
%>

	<div class="row">
		<div class="col-md-offset-2 col-md-6 contactGroupe">				
				<%
					if(lesGroupes != null) {
				%>
						
						<h1 class="formName col-md-offset-4">
							<bean:message key="groupe.contact.list" />
						</h1>
						<table class="table table-striped table-bordered col-md-offset-2">
							<thead>
								<tr>
									<th><bean:message key="groupe.name" /></th>
								</tr>
							</thead>
				<%
						for(int key : lesGroupes.keySet()) {
				%>
						<tr>
							<td><%= lesGroupes.get(key) %></td>
							<td><html:link action="/RemoveFromGroupe">
									<html:param name="idGroupe"><%= key %></html:param>
									<span class="glyphicon glyphicon-remove"></span>
								</html:link></td>
						</tr>
				
			<%
						}
			%>
			
			</table>
			
			<%
				}
					else {
						%>
							<h1 class = "col-md-offset-4 groupeNone">
								<bean:message key = "groupe.none"/>
							</h1>
						<%
					}
			%>
		</div>
	</div>	

</body>
</html:html>