<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>         


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<nav class="navbar navbar-default">
    <div class="row">
        <ul class="nav navbar-nav col-md-6">
            <li class="col-md-6">
                <html:link action="/Accueil"><bean:message key="main.accueil"/></html:link>
            </li>
            <li class="col-md-6">
                <html:link action="createContact.jsp"><bean:message key="main.ajouter"/></html:link>
            </li>
        </ul>
        <div class="col-md-6">
            <html:form action="/SearchContact" styleClass="navbar-form inline-form" method = "post">
                <div class="form-group">
                    <html:text property ="firstName" styleClass="input-md form-control"/>
                    <!--<html:submit styleClass="btn btn-primary btn-md"><span class="glyphicon glyphicon-eye-open"></span> Rechercher un contact</html:submit>-->
                    <html:submit styleClass="btn btn-primary btn-md" value = "Rechercher un contact"/>
                </div>
            </html:form>
        </div>
    </div>
</nav>