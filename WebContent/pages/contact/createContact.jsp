<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isErrorPage="true"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>

<jsp:include page="../elements/entete.jsp"></jsp:include>
  
   <html:html>

   <head>

   <title><bean:message key="add.contact"/></title>

   <html:base/>

   </head>

   <body bgcolor="white">

	<div class="row">
		<div class="col-md-offset-2 col-md-6">
		
			<html:form styleClass="form-horizontal" action ="/AddContact" method ="post">
	            <fieldset>
	                <h1 class="formName col-md-offset-4"><bean:message key="add.contact"/></h1>
	                <div class="form-group">
	
		                <label class="col-md-4 control-label"><bean:message key="contact.prenom"/></label>
	                    <div class="col-md-8">
	                        <html:text styleClass="form-control inputForm" property ="firstName"/>
	                    </div>
	                    <div class="col-md-offset-2 error">
	                    	<html:errors property="first name"/><br>
	                    	<html:errors property="incorrect first name"/>
	                    </div>
	                    	                    
	                    <label class="col-md-4 control-label"><bean:message key="contact.nom"/></label>
	                    <div class="col-md-8">
	                        <html:text styleClass="form-control inputForm" property = "lastName"/>
	                    </div>
	                    <div class="col-md-offset-2 error">
	                    	<html:errors property="last name"/><br>
	                    	<html:errors property="incorrect last name"/>
	                    </div>
	
	                    <label class="col-md-4 control-label"><bean:message key="contact.email"/></label>
	                    <div class="col-md-8">
	                        <html:text styleClass="form-control inputForm" property="email"/>
	                    </div>
	                    <div class="col-md-offset-2 error">
	                    	<html:errors property="email"/>
	                    	<html:errors property="incorrect email"/>
	                    	<html:errors property="contact.already.exists"/>
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

