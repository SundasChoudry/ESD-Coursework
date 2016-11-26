<%-- 
    Document   : ManageUserBalance
    Created on : 25-Nov-2016, 05:31:34
    Author     : tomfisher
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/resources/UserDashboardNavBar.jsp" %>
<div class="main">
        <form action="${pageContext.request.contextPath}/UserController" method="post">
            <input type="hidden" name="viewId" value="/UserBalance">
            <input type="hidden" name="username" value="${sessionScope.username}">
            <input class="btn" type="submit" name="viewId" value="/UserClaimConfirm">
        </form>
</div>