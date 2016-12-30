<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@page import="java.util.ArrayList" %>
<%@page import="models.Contact" %>

	<div class="row">
		<div class="col-md-offset-4 col-md-5">
			<h1>			
				<% if(request.getAttribute("pattern") != null) {
					%> <bean:message key ="main.searchedContact"/> <%= request.getAttribute("pattern") %>
				<% } else {
					%> <bean:message key ="main.listContact"/> <%
				}
				%>
			</h1>
		</div>
		<div class="col-md-offset-2 col-md-1 add-btn">
			<h1>
				<html:link action="createContact.jsp"><message:bean key="add.contact"/>
				<span class = "glyphicon glyphicon-plus-sign"></html:link></span>
			</h1>
		</div>
	</div>
	<table class = "table table-striped table-bordered">
		<thead>
			<tr>
				<th><bean:message key="contact.prenom"/></th>
				<th><bean:message key="contact.nom"/></th>
				<th><bean:message key="contact.email"/></th>
			</tr>
		</thead>
 			<%
				ArrayList<Contact> lesContacts = (ArrayList<Contact>)request.getAttribute("lesContacts");
				for(Contact contact : lesContacts)
				{
			%>
					<tr>					
						<td><%= contact.getFirstName() %></td>
						<td><%= contact.getLastName() %></td>
						<td><%= contact.getEmail() %></td>
						<td><html:link action ="contact/updateContact.jsp">
								<html:param name="idContact"><%= contact.getIdContact() %></html:param>
								<span class = "glyphicon glyphicon-pencil"></span>
							</html:link>
						</td>
						<td>
							<html:link action ="/DeleteContact">
								<html:param name = "idContact"><%= contact.getIdContact()%></html:param>
								<span class="glyphicon glyphicon-remove"></span>
							</html:link>
						</td>
					</tr>
			<%
				}
			%>
	</table>