<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@page import="java.util.ArrayList" %>
<%@page import="models.Contact" %>

	<div class="row">
		<div class="col-md-offset-4 col-md-4">
			<h1><bean:message key ="main.listContact"/></h1>
		</div>
		<div class="col-md-offset-3 col-md-1 add-btn">
			<h1>
				<html:link action="createContact.jsp"><message:bean key="add.contact"/>
				<span class = "glyphicon glyphicon-plus-sign"></html:link></span>
			</h1>
		</div>
	</div>
	<table class = "table table-striped table-bordered">
		<thead>
			<tr>
				<th>Prénom</th>
				<th>Nom</th>
				<th>Email</th>
			</tr>
		</thead>
 			<%
				ArrayList<Contact> lesContacts = (ArrayList)request.getAttribute("lesContacts");
				for(Contact contact : lesContacts)
				{
			%>
					<tr>					
						<td><%= contact.getFirstName() %></td>
						<td><%= contact.getLastName() %></td>
						<td><%= contact.getEmail() %></td>
						<td><html:link action ="updateContact.jsp">
								<html:param name="id"><%= contact.getId() %></html:param>
								<span class = "glyphicon glyphicon-pencil"></span>
							</html:link>
						</td>
						<td>
							<html:link action ="/DeleteContact">
								<html:param name = "id"><%= contact.getId()%></html:param>
								<span class="glyphicon glyphicon-remove"></span>
							</html:link>
						</td>
					</tr>
			<%
				}
			%>
	</table>