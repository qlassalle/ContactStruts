<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><bean:message key="application.name"/></title>
</head>
<body>
	<h1><bean:message key="application.name"/></h1>
	
	<html:form method="post" action="/Login">
		<bean:message key="contact.nom"/> : <input type = "text" name = "name">
		<bean:message key="login.password"/> : <input type = "password" name = "password">
		
		<input type ="submit">
	</html:form>
</body>
</html>