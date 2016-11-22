<%-- 
    Document   : UserLogin
    Created on : 11-Nov-2016, 15:56:25
    Author     : Susan Rai
--%>
<div class="main">
    <div class="content-screen">
        <div class="title">
            <h1>Login</h1>
        </div>
        <form class="form" name="login" action="${pageContext.request.contextPath}/Login" method="post">
            <input class="control-group" type="text" name="username"  value="" placeholder="Username" required>
            <input class="control-group" type="password" name="password" value="" placeholder="Password" required>
            <input class="btn" type="submit" value="Login">
            <input class="btn" type="reset" value="Reset">

            <!--Dispaly the error message-->
            <td><%=(request.getAttribute("ErrorMessage") == null) ? "" : request.getAttribute("ErrorMessage")%>
        </form>
    </div>
</div>