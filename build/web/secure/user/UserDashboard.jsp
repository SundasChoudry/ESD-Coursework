<%-- 
    Document   : UserDashBoard
    Created on : 11-Nov-2016, 21:08:48
    Author     : susan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
        <title>User DashBoard</title>
    </head>
    <body> 
        <%@ include file="/resources/Header.jsp" %>
        <% String id = null;
            if (session.getAttribute("ID") == null) {
                RequestDispatcher view = request.getRequestDispatcher("/docs/Login");
                view.forward(request, response);
            }
        %>
        <div class="login">
            <div class="login-screen">
                <div class="title">
                    <h1>Welcome <br><%=session.getAttribute("ID")%></h1>
                </div>              
            </div>
        </div>
    </body>
</html>
