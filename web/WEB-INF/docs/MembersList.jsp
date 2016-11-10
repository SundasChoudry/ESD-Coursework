<%-- 
    Document   : main
    Created on : 10-Nov-2016, 13:16:36
    Author     : Nate
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/resources/AdminDashboardNavBar.jsp" %>

<div class="content">
    <h1>XYZ Members</h1>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>DOB</th>
            <th>DOR</th>
            <th>Membership</th>
            <th>Balance</th>
        </tr>
        <c:forEach items="${membersList}" var="row" varStatus="status">
            <tr>
                <c:forEach items="${row}" var="column" varStatus="status">
                    <c:choose>
                        <c:when test="${column.getClass().name eq 'java.lang.Float'}">
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
