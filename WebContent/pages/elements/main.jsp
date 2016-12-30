<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested" %>
<jsp:include page="../elements/entete.jsp"></jsp:include>
	<title><bean:message key="main.page.menu"/></title>


	<jsp:include page="../elements/contactDisplay.jsp"></jsp:include>
	<jsp:include page="../elements/groupeDisplay.jsp"></jsp:include>
	<jsp:include page="../elements/adresseDisplay.jsp"></jsp:include>
</body>

</html>