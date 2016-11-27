<%-- 
    Document   : UserDashboardNavBar
    Created on : 25-Nov-2016, 03:07:36
    Author     : tomfisher
--%>
<div class="navBar">
    <ul class="menu">
        <li><a href="${pageContext.request.contextPath}/docs/user/UserDashboard">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/docs/user/ManageUserBalance">Balance</a></li>
        <li><a href="${pageContext.request.contextPath}/docs/user/UserMakeClaim">Make claim</a></li>
        <li><a href="${pageContext.request.contextPath}/docs/user/UserMakePayment">Make payment</a></li>
        <li><a href="${pageContext.request.contextPath}/docs/user/ManageUserClaims">Claims</a></li>
        <li><a href="${pageContext.request.contextPath}/docs/user/ManageUserPayments">Payments</a></li>

    </ul>
</div>
<div class="logout">
    <form class="form" action="${pageContext.request.contextPath}/Logout" method="post">
        <input class="logoutBtn" type="submit" value="Logout" >
    </form>
</div>