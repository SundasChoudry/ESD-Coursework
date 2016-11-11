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
        <title>User Login</title>
    </head>
    <body> 
        <div class="login">
            <div class="login-screen">
                <div class="title">
                    <h1>User Login</h1>
                </div>

                <div class="login-form">
                    <div class="control-group">
                        <input type="text" name="username" class="login-field" value="" placeholder="username">
                    </div>

                    <div class="control-group">
                        <input type="password" name="password" class="login-field" value="" placeholder="password">
                    </div>

                    <a class="btn" href="#">login</a>
                </div>
            </div>
        </div>
    </body>
</html>
