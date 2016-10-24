<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@page import="java.util.ArrayList" %>
<%@page import="models.Groupe" %>

	<div class="row">
		<div class="col-md-offset-4 col-md-4">
			<h1><bean:message key ="main.listGroupe"/></h1>
		</div>
		<div class="col-md-offset-3 col-md-1 add-btn">
			<h1>
				<html:link action="groupe/createGroupe.jsp"><message:bean key="add.groupe"/>
				<span class = "glyphicon glyphicon-plus-sign"></html:link></span>
			</h1>
		</div>
	</div>
		<table class = "table table-striped table-bordered">
			<thead>
				<tr>
					<th>Nom du groupe</th>
					<th>Nombre de membres</th>
				</tr>
			</thead>
					<%
					ArrayList<Groupe> lesGroupes = (ArrayList)request.getAttribute("lesGroupes");
					ArrayList<Integer> nbMembre = (ArrayList)request.getAttribute("nbMembre");
					int id, i = 0;
					for(Groupe groupe : lesGroupes)
					{
						id = groupe.getId();
						%>
						<tr>
							<td><%= groupe.getName() %></td>
							<td><span class="badge"><%= nbMembre.get(i) %></span></td>
							<td><html:link action ="/GetGroupeInfo">
									<html:param name ="id"><%= id %></html:param>
									<span class = "glyphicon glyphicon-pencil"></span>
								</html:link>
							</td>
							<td>
								<html:link action ="/DeleteGroupe">
									<html:param name = "id"><%= id%></html:param>
									<span class="glyphicon glyphicon-remove"></span>
								</html:link>
							</td>
						</tr>
						<%
						i++;
					}
					%>
		</table>