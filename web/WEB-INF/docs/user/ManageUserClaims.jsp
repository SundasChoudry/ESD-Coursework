<%-- 
    Document   : UserBalance
    Created on : 25-Nov-2016, 03:12:50
    Author     : tomfisher
--%>

<%@page import="model.JDBCBean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/resources/UserDashboardNavBar.jsp" %>

<div class="main">
    <form id="hidden" class="form" action="${pageContext.request.contextPath}/UserController" method="post" style="text-align: center;">
        <input type="hidden" name="viewId" value="/UserListClaims">
        <input type="hidden" name="username" value="${sessionScope.username}">
    </form>
</div>
<script type="text/javascript">
    document.getElementById('hidden').submit();
</script>
