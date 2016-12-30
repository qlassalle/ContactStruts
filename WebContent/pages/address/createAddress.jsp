<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<jsp:include page="../elements/entete.jsp"></jsp:include>


	<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><bean:message key="add.address"/></title>
	</head>
	
	<body>
	
	<div class="row">
		<div class="col-md-offset-2 col-md-6">
			<html:form styleClass="form-horizontal" action ="/AddAddress" method ="post">
	            <fieldset>
	                <h1 class="formName col-md-offset-4"><bean:message key="add.address"/></h1>
	                <div class="form-group">
	
	                    <label class="col-md-4 control-label"><bean:message key="adresse.rue"/></label>
	                    <div class="col-md-8">
	                        <html:text styleClass="form-control inputForm" property = "street"/>
	                    </div>
	                    <div class="col-md-offset-2 error">
	                    	<html:errors property="street"/>
	                    	<br>
	                    	<html:errors property="incorrect street"/>
	                    </div>
	
	                    <label class="col-md-4 control-label"><bean:message key="adresse.ville"/></label>
	                    <div class="col-md-8">
	                        <html:text styleClass="form-control inputForm" property ="city"/>
	                    </div>
	                    <div class="col-md-offset-2 error">
	                    	<html:errors property="city"/>
	                    	<br>
	                    	<html:errors property="incorrect city"/>
	                    </div>
	
	                    <label class="col-md-4 control-label"><bean:message key="adresse.zip"/></label>
	                    <div class="col-md-8">
	                        <html:text styleClass="form-control inputForm" property="zip"/>
	                    </div>
	                    <div class="col-md-offset-2 error">
	                    	<html:errors property="zip"/>
	                    	<br>
	                    	<html:errors property="incorrect zip"/>
	                    </div>
	                    
	                    <label class="col-md-4 control-label"><bean:message key="adresse.pays"/></label>
	                    <div class="col-md-8">
	                        <html:text styleClass="form-control inputForm" property="country"/>
	                    </div>	
	                    <div class="col-md-offset-2 error">
	                    	<html:errors property="country"/>
	                    	<br>
	                    	<html:errors property="incorrect country"/>
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