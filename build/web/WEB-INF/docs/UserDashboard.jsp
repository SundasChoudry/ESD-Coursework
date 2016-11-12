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
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
        <title>User DashBoard</title>
    </head>
    <body> 
        <div class="login">
            <div class="login-screen">
                <div class="title">
                    <h1>Welcome <br><%=request.getAttribute("ID")%></h1>
                </div>              
            </div>
        </div>
    </body>
</html>
