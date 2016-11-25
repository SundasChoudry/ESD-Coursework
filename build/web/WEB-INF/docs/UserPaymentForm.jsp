<%-- 
    Document   : UserClaimForm
    Created on : 25-Nov-2016, 06:10:55
    Author     : tomfisher
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/resources/UserDashboardNavBar.jsp" %>
<div class="content">
    <h1>Make Payment</h1>
    <form class="content-screen" action="${pageContext.request.contextPath}/UserController" method="post" style="text-align: center;">
        Payment Amount:<br>
        <input type="text" name="amount">
        <br><br>
        Payment Type<br>
        <input type="text" name="paymentType">
        <br><br>
        <input type="hidden" name="viewId" value="/UserMakePayment">
        <input type="hidden" name="username" value="${sessionScope.username}">
        <input class="btn" type="submit" value="Submit Payment"/>
    </form>
</div>