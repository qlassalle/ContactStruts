<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<jsp:include page="../entete.jsp"></jsp:include>


	<html:html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ajouter une adresse</title>
	</head>
	
	<body>
	
	<div class="row">
		<div class="col-md-offset-2 col-md-6">
			<html:form styleClass="form-horizontal" action ="/AddAddress" method ="post">
			<html:errors/>
	            <fieldset>
	                <h1 class="formName col-md-offset-4"><bean:message key="add.address"/></h1>
	                <div class="form-group">
	
	                    <label class="col-md-4 control-label">Rue</label>
	                    <div class="col-md-8">
	                        <html:text styleClass="form-control inputForm" property = "street"/>
	                    </div>
	
	                    <label class="col-md-4 control-label">Ville</label>
	                    <div class="col-md-8">
	                        <html:text styleClass="form-control inputForm" property ="city"/>
	                    </div>
	
	
	                    <label class="col-md-4 control-label">Code postal</label>
	                    <div class="col-md-8">
	                        <html:text styleClass="form-control inputForm" property="zip"/>
	                    </div>
	                    
	                    <label class="col-md-4 control-label">Pays</label>
	                    <div class="col-md-8">
	                        <html:text styleClass="form-control inputForm" property="country"/>
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