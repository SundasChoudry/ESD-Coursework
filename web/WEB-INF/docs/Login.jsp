<%-- 
    Document   : UserLogin
    Created on : 11-Nov-2016, 15:56:25
    Author     : Susan Rai
--%>
<div class="login">
    <div class="login-screen">
        <div class="title">
            <h1>Login</h1>
        </div>
        <form class="login-form" name="login" action="${pageContext.request.contextPath}/Login" method="post">
            <input class="control-group" type="text" name="username" class="login-field" value="${user.userName}" placeholder="Username">
            <input class="control-group" type="password" name="password" class="login-field" value="${user.password}" placeholder="Password">
            <input class="btn" type="submit" value="Login">

            <!--Dispaly the error message-->
            <td><%=(request.getAttribute("ErrorMessage") == null) ? "" : request.getAttribute("ErrorMessage")%></td>
        </form>
    </div>
</div>
