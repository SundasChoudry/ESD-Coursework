<%-- 
    Document   : ClaimsLIst
    Created on : 22-Nov-2016, 19:50:33
    Author     : Nate
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/resources/AdminDashboardNavBar.jsp" %>
${JDBCBean.executeSQLQuery("SELECT * FROM Claims WHERE status='PENDING'")}
<div class="content">
    <h1>Claims</h1>
    <form action="${pageContext.request.contextPath}/AdminController" method="post">
        <table>
            <tr>
                <th>ID</th>
                <th>Member ID</th>
                <th>Date</th>
                <th>Rationale</th>
                <th>Status</th>
                <th>Amount</th>
                <th>Select</th> 
            </tr>
            <c:forEach items="${JDBCBean.resultsToArrayList()}" var="row" varStatus="rowStatus">
                <tr>
                    <c:forEach items="${row}" var="column" varStatus="columnStatus">
                        <c:choose>
                            <c:when test="${columnStatus.last}">
                                <td>£${column}</td>
                                <td><input class="radio" type="radio" name="tableSelection" value="${row[0]}" ${rowStatus.first ? 'checked="checked"' : ''}/></td>
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
        <input class="btn" type="submit" value="View Selected"/>
    </form>
</div>