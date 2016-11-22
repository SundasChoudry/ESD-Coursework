<%-- 
    Document   : main
    Created on : 10-Nov-2016, 13:16:36
    Author     : Nate
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/resources/AdminDashboardNavBar.jsp" %>

<!-- Example Content -->
<div class="content">
    <h1>Admin Dashboard</h1>
    ${pageContext.request.contextPath}
<%--
    ${pageContext.request.getHeader("Referer")}
    ${pageContext.request.getParameter("rowRadio")}

    ${JDBCBean.executeSQLQuery("SELECT * FROM members WHERE id=''")}
--%>
    <div style="height:600px;">
        <a href="http://imgur.com/k9hz3">
            <img src="http://i.imgur.com/k9hz3.jpg" title="Hosted by imgur.com" alt="" />
        </a>
    </div>
    <div style="height:600px;">
        <a href="http://imgur.com/TXuFQ">
            <img src="http://i.imgur.com/TXuFQ.jpg" title="Hosted by imgur.com" alt="" />
        </a>
    </div>
</div>


