<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<jsp:include page="entete.jsp"></jsp:include>
  
   <html:html>

   <head>

   <title><bean:message key="add.contact"/></title>

   <html:base/>

   </head>

   <body bgcolor="white">

	<div class="row">
		<div class="col-md-offset-2 col-md-6">
			<html:form styleClass="form-horizontal" action ="/AddContact" method ="post">
			<html:errors/>
	            <fieldset>
	                <h1 class="formName col-md-offset-4"><bean:message key="add.contact"/></h1>
	                <div class="form-group">
	
	                    <label class="col-md-4 control-label">Nom</label>
	                    <div class="col-md-8">
	                        <html:text styleClass="form-control inputForm" property = "firstName"/>
	                    </div>
	
	                    <label class="col-md-4 control-label">Prénom</label>
	                    <div class="col-md-8">
	                        <html:text styleClass="form-control inputForm" property ="lastName"/>
	                    </div>
	
	
	                    <label class="col-md-4 control-label">Mail</label>
	                    <div class="col-md-8">
	                        <html:text styleClass="form-control inputForm" property="email"/>
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

