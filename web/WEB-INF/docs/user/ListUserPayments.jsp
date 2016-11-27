<%-- 
    Document   : UserBalance
    Created on : 25-Nov-2016, 03:12:50
    Author     : tomfisher
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/resources/UserDashboardNavBar.jsp" %>

<div class="content">
    <h1>Your Payments</h1>
    <table>
        <tr>
            <th>ID</th>
            <th>Member ID</th>
            <th>Type of Payment</th>
            <th>Amount</th>
            <th>Date</th>
        </tr>
        <c:forEach items="${data}" var="row" varStatus="rowStatus">
            <tr>
                <c:forEach items="${row}" var="column" varStatus="columnStatus">
                    <c:choose>
                        <c:when test="${columnStatus.last}">
                            <td>£${column}</td>                           
                        </c:when>
                        <c:otherwise>
                            <td>${column}</td>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</div>
