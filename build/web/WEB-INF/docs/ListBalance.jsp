<%-- 
    Document   : BalanceList
    Created on : 21-Nov-2016, 22:17:36
    Author     : Nate
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/resources/AdminDashboardNavBar.jsp" %>

<div style="display: none;">
    ${JDBCBean.executeSQLQuery("SELECT * FROM members WHERE status='APPROVED' AND balance>'0.0'")}
</div>

<div class="content">
    <h1>Outstanding Balances</h1>
    
    <form action="${pageContext.request.contextPath}/AdminController" method="post">
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Address</th>
                <th>DOB</th>
                <th>DOR</th>
                <th>Membership</th>
                <th>Balance</th>
                <th>Select</th>
            </tr>
            <c:forEach items="${JDBCBean.resultsToArrayList()}" var="row" varStatus="rowStatus">
                <tr>
                    <c:forEach items="${row}" var="column" varStatus="columnStatus">
                        <c:choose>
                            <c:when test="${columnStatus.last}">
                                <td>�${column}</td>
                                <td><input class="radio" type="radio" name="selectedMember" value="${row[0]}" ${rowStatus.first ? 'checked="checked"' : ''}/></td>
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
        <input type="hidden" name="viewId" value="/ListBalance">
        <input class="btn" type="submit" value="View Selected"/>
    </form>       
</div>