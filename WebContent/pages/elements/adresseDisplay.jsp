<%@page import="java.util.ArrayList" %>
<%@page import="models.Address" %>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>

	<div class="row">
		<div class="col-md-offset-4 col-md-4">
			<h1><bean:message key ="main.listAdresse"/></h1>
		</div>
		<div class="col-md-offset-3 col-md-1 add-btn">
			<h1>
				<html:link action="address/createAddress.jsp">
				<span class = "glyphicon glyphicon-plus-sign"></html:link></span>
			</h1>
		</div>
	</div>
		<table class = "table table-striped table-bordered">
		<thead>
			<tr>
				<th><bean:message key="adresse.rue" /></th>
				<th><bean:message key="adresse.ville" /></th>
				<th><bean:message key="adresse.zip" /></th>
				<th><bean:message key="adresse.pays" /></th>
			</tr>
		</thead>
		<%
			ArrayList<Address> lesAdresses = (ArrayList<Address>)request.getAttribute("lesAdresses");
			int id, i = 0;
			for (Address address : lesAdresses) {
		%>
				<tr>
					<td><%=address.getStreet()%></td>
					<td><%=address.getCity()%></td>
					<td><%=address.getZip()%></td>
					<td><%=address.getCountry()%></td>
					<td><html:link action="address/updateAddress.jsp">
							<html:param name="idAddress"><%=address.getId()%></html:param>
							<span class="glyphicon glyphicon-pencil"></span>
						</html:link></td>
					<td><html:link action="/DeleteAddress">
							<html:param name="id"><%=address.getId()%></html:param>
							<span class="glyphicon glyphicon-remove"></span>
						</html:link></td>
				</tr>
			<%
				i++;
			}
			%>
		</table>
		
		