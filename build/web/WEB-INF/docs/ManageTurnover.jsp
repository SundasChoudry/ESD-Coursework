<%-- 
    Document   : Turnover
    Created on : 24-Nov-2016, 22:51:11
    Author     : Nate
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/resources/AdminDashboardNavBar.jsp" %>

<div style="display: none;">
    ${JDBCBean.executeSQLQuery("SELECT * FROM claims WHERE status='APPROVED' AND date >= DATE_SUB(NOW(),INTERVAL 1 YEAR)")}
</div>

<div class="content">
    <h1>Manage XYZ Finances</h1> 

    <h2>Years Claims</h2>
    <br>
    <table>
        <tr>
            <th>ID</th>
            <th>Member ID</th>
            <th>Date</th>
            <th>Rationale</th>
            <th>Status</th>
            <th>Amount</th>
        </tr>
        <c:forEach items="${JDBCBean.resultsToArrayList()}" var="row" varStatus="rowStatus">
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
    <br><br>


</div>