<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<html:html>
	<head>
		<title><bean:message key="title.error"/></title>
	</head>
	<body>
	Erreur à gérer !!
		<html:errors/><br/> 
	</body>
</html:html>
