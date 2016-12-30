<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<jsp:include page="../elements/entete.jsp"></jsp:include>
  
   <html:html>

   <head>

   <title><bean:message key="groupe.ajouter"/></title>

   <html:base/>

   </head>

   <body bgcolor="white">

	<div class="row">
		<div class="col-md-offset-2 col-md-6">
			<html:form styleClass="form-horizontal" action ="/AddGroupe" method ="post">
	            <fieldset>
	                <h1 class="formName col-md-offset-4"><bean:message key="groupe.ajouter"/></h1>
	                <div class="form-group">
	
	                    <label class="col-md-4 control-label"><bean:message key ="groupe.name"/></label>
	                    <div class="col-md-8">
	                        <html:text styleClass="form-control inputForm" property = "name"/>
	                    </div>
	                    
	                    <div class="error">
							<html:errors/>
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