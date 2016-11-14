<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<%@page import="services.PhoneNumberService"%>
<%@page import="models.PhoneNumber"%>
<jsp:include page="../entete.jsp"></jsp:include>


<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><bean:message key="maj.phoneNumber" /></title>
</head>

	<%
		PhoneNumberService ps = new PhoneNumberService();
		int idPhone;
		try {
			idPhone = Integer.valueOf(request.getParameter("id"));
			request.getSession().setAttribute("idPhone", idPhone);
		}
		// nfe is raised if there's an error and id isn't present
		catch (NumberFormatException nfe) {
			idPhone = (int)request.getSession().getAttribute("idPhone");
		}
		request.getSession().setAttribute("idPhone", idPhone);
		PhoneNumber number = ps.getPhoneNumber(idPhone);
	%>

<body>
	<div class="row">
		<div class="col-md-offset-2 col-md-6">
			<html:form styleClass="form-horizontal" action="/UpdatePhoneNumber"	method="post">
				<html:errors/>
				<fieldset>
					<h1 class="formName col-md-offset-4">
						<bean:message key="maj.phoneNumber" />
					</h1>
					<div class="form-group">

						<label class="col-md-4 control-label"><bean:message	key="phoneNumber.kind" /></label>
						<div class="col-md-8">
							<html:text styleClass="form-control inputForm" property="kind" value = "<%= number.getKind() %>"/>
						</div>

						<label class="col-md-4 control-label"><bean:message	key="phoneNumber.number" /></label>
						<div class="col-md-8">
							<html:text styleClass="form-control inputForm" property="number" value = "<%= number.getNumber() %>"/>
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