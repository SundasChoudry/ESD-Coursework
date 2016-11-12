<%-- 
    Document   : UserLogin
    Created on : 11-Nov-2016, 15:56:25
    Author     : susan
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
        <title>Login</title>
    </head>
    <body> 
        <div class="login">
            <div class="login-screen">
                <div class="title">
                    <h1>Login</h1>
                </div>
                <form class="login-form" name="login" action="${pageContext.request.contextPath}/Login" method="post">
                    <input class="control-group" type="text" name="ID" class="login-field" value="" placeholder="Username">
                    <input class="control-group" type="password" name="password" class="login-field" value="" placeholder="Password">
                    <input class="btn" type="submit" value="Login">
                    
                    <td><%=(request.getAttribute("ErrorMessage") == null) ? "" : request.getAttribute("ErrorMessage")%></td>
                </form>
                
            </div>
        </div>
    </body>
</html>
