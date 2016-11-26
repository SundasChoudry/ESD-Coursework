<%-- 
    Document   : UserClaimForm
    Created on : 25-Nov-2016, 06:10:55
    Author     : tomfisher
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/resources/UserDashboardNavBar.jsp" %>
<div class="main">
    <div class="content-screen">
        <div class="title">
            <h1>Make Claim</h1>
        </div>
        <form class="form" action="${pageContext.request.contextPath}/UserController" method="post" style="text-align: center;">
            Claim Amount:<br>
            <input type="number" name="amount">
            <br><br>
            Claim Rationale:<br>
            <input type="number" name="rationale">
            <br><br>
            <input type="hidden" name="viewId" value="/UserMakeClaim">
            <input type="hidden" name="username" value="${sessionScope.username}">
            <input class="btn" type="submit" value="Submit Claim"/>
            <input class="btn" type="reset" value="Reset">
        </form>
    </div>
</div>