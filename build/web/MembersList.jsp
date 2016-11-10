<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/main.css">
        <title>Members List</title>
    </head>
    <body>
        <%@ include file="/resources/Header.html" %>
        <%@ include file="/resources/AdminDashboardNavBar.html" %>

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

    </body>
</html>
