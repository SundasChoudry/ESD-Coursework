<%-- 
    Document   : UserBalance
    Created on : 25-Nov-2016, 03:12:50
    Author     : tomfisher
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/resources/UserDashboardNavBar.jsp" %>

<div class="main">
    <div class="content-screen">
        <div class="title">
            <c:forEach items="${balance}" var="row" varStatus="rowStatus">
                <h1>${username}, Your current balance is £${row[0]}</h1>
            </c:forEach>
        </div>              
    </div>
</div>
