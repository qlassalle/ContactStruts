<%@page import="services.AddressService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<%@page import="services.AddressService"%>
<%@page import="models.Address"%>

<jsp:include page="../elements/entete.jsp"></jsp:include>
<head>
	<title><bean:message key="maj.address.title" /></title>
</head>
<body>
	
	<%
		AddressService as = new AddressService();
		int idAddress;
		try {
			idAddress = Integer.valueOf(request.getParameter("idAddress"));
			request.getSession().setAttribute("idAddress", idAddress);
		} 
		// nfe is raised if there's an error and id isn't present
		catch (NumberFormatException nfe) {
			idAddress = (int)request.getSession().getAttribute("idAddress");
		}
		Address add = as.getAddress(idAddress);
	%>
	
	<div class="row">
		<div class="col-md-offset-2 col-md-6">
			<html:form styleClass="form-horizontal" action ="/UpdateAddress" method ="post">
	            <fieldset>
	                <h1 class="formName col-md-offset-4"><bean:message key="maj.address"/></h1>
	                <div class="form-group">
	
	                    <label class="col-md-4 control-label"><bean:message key="adresse.rue"/></label>
	                    <div class="col-md-8">
	                        <html:text styleClass="form-control inputForm" property = "street" value ="<%= add.getStreet() %>"/>
	                    </div>
	                    <div class="col-md-offset-2 error">
	                    	<html:errors property="street"/>
	                    	<br>
	                    	<html:errors property="incorrect street"/>
	                    </div>
	
	                    <label class="col-md-4 control-label"><bean:message key="adresse.ville"/></label>
	                    <div class="col-md-8">
	                        <html:text styleClass="form-control inputForm" property ="city" value ="<%= add.getCity() %>"/>
	                    </div>
	                    <div class="col-md-offset-2 error">
	                    	<html:errors property="city"/>
	                    	<br>
	                    	<html:errors property="incorrect city"/>
	                    </div>
	
	                    <label class="col-md-4 control-label"><bean:message key="adresse.zip"/></label>
	                    <div class="col-md-8">
	                        <html:text styleClass="form-control inputForm" property="zip" value ="<%= add.getZip() %>"/>
	                    </div>
	                    <div class="col-md-offset-2 error">
	                    	<html:errors property="zip"/>
	                    	<br>
	                    	<html:errors property="incorrect zip"/>
	                    </div>
	                    
	                    <label class="col-md-4 control-label"><bean:message key="adresse.pays"/></label>
	                    <div class="col-md-8">
	                        <html:text styleClass="form-control inputForm" property="country" value ="<%= add.getCountry() %>"/>
	                    </div>	
	                    <div class="col-md-offset-2 error">
	                    	<html:errors property="country"/>
	                    	<br>
	                    	<html:errors property="incorrect country"/>
	                    </div>
	                    
	                    <html:hidden property = "id" value = '<%= request.getParameter("idAddress") %>' />
	                    <div class="col-md-offset-7">
	                        <html:submit styleClass="btn btn-primary validerForm" value="Valider" />
	                    </div>
	                </div>
	            </fieldset>
			</html:form>
		</div>
	</div>	
	
</body>
</html>