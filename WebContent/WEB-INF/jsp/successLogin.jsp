<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
       <c:set var="cp"
	value="${pageContext.request.servletContext.contextPath}" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="${cp}/static/style.css">
        <title>JSP Page</title>
    </head>
    <body>
	<h1> Erfolgreich eingeloggt! </h1>
    </body>
</html>