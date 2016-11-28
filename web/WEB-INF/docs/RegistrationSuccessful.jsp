<%-- 
    Document   : RegistrationSuccessful
    Author     : Loy
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="main">
    <div class="content-screen">
        <div class="title">
            <h1>Registration Successful</h1>
            <p>Welcome <b>${registeredUsername}</b></p>
            <p>Your Password is <b>${registeredUsernamePassword}</b></p>
        </div>
        <a class="btn" href="${pageContext.request.contextPath}/docs/Login">Login Page</a>
    </div>
</div>


