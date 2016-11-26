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
            <h1>Make Payment</h1>
        </div>
        <form class="form" action="${pageContext.request.contextPath}/UserController" method="post" style="text-align: center;">
            Payment Amount:<br>
            <input type="number" name="amount">
            <br><br>
            Payment Type<br>
            <input type="text" name="paymentType">
            <br><br>
            <input type="hidden" name="viewId" value="/UserMakePayment">
            <input type="hidden" name="username" value="${sessionScope.username}">
            <input class="btn" type="submit" value="Submit Payment"/>
            <input class="btn" type="reset" value="Reset">
        </form>
    </div>
</div>