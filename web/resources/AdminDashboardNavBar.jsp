<%-- 
    Document   : AdminDashboardNavBar
    Created on : 10-Nov-2016, 15:38:46
    Author     : Nate
--%>
<div class="navBar">
    <ul class="menu">
        <li><a href="${pageContext.request.contextPath}/docs/AdminDashboard">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/docs/ListMembers">Members</a></li>
        <li><a href="${pageContext.request.contextPath}/docs/ListBalance">Balances</a></li>
        <li><a href="${pageContext.request.contextPath}/docs/ListClaims">Claims</a></li>
        <li><a href="${pageContext.request.contextPath}/docs/ListApplications">Applications</a></li>
        <li><a href="${pageContext.request.contextPath}/docs/ManageTurnover">Turnover</a></li>
    </ul>
</div>
    <div class="logout">
    <form class="form" action="${pageContext.request.contextPath}/Logout" method="post">
        <input class="logoutBtn" type="submit" value="Logout" >
    </form>
</div>
