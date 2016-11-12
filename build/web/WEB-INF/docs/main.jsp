<%-- 
    Document   : main
    Created on : 10-Nov-2016, 13:16:36
    Author     : Nate
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
        <title>XYZ Main Page</title>
    </head>
    <body>
        <%@ include file="/resources/Header.jsp" %>
        <jsp:include page="${requestScope.included}" flush="true" />        
    </body>
</html>
