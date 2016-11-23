<%-- 
    Document   : ManageMember
    Created on : 22-Nov-2016, 20:39:17
    Author     : Nate
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/resources/AdminDashboardNavBar.jsp" %>

<div class="content">
    <h1>Manage Member ${requestedMember[1]}</h1>
    TODO: add member details
    hide suspend/resume? or prevent from doing incorrect behaviour<br>
    ALSO change user status

    <form action="${pageContext.request.contextPath}/AdminController" method="post">    
        <h2>Claims</h2>
        <br>
        <table>
            <tr>
                <th>Date</th>
                <th>Rationale</th>
                <th>Status</th>
                <th>Amount</th>               
            </tr>
            <c:forEach items="${requestedClaims}" var="row" varStatus="rowStatus">
                <tr>
                    <c:forEach items="${row}" var="column" varStatus="columnStatus">
                        <c:choose>
                            <c:when test="${columnStatus.last}">
                                <td>£${column}</td>
                            </c:when>
                            <c:otherwise>
                                <c:if test="${columnStatus.index ne 0 and columnStatus.index ne 1}">
                                    <td>${column}</td>
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
        <br><br>
        <h2>Payments</h2>
        <table>
            <tr>
                <th>Type</th>
                <th>Amount</th>
                <th>Date</th>                          
            </tr>
            <c:forEach items="${requestedPayments}" var="row" varStatus="rowStatus">
                <tr>
                    <c:forEach items="${row}" var="column" varStatus="columnStatus">
                        <c:choose>
                            <c:when test="${columnStatus.index eq 3}">
                                <td>£${column}</td>
                            </c:when>
                            <c:otherwise>
                                <c:if test="${columnStatus.index ne 0 and columnStatus.index ne 1}">
                                    <td>${column}</td>
                                </c:if>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
        <br><br>
        <input type="hidden" name="viewId" value="/ManageMember">
        <button class="btn" type="submit" name="manageMemberAction" value="suspend_${requestedMember[0]}">Suspend</button>
        <button class="btn" type="submit" name="manageMemberAction" value="resume_${requestedMember[0]}">Resume</button>
    </form>
</div>
