<%-- 
    Document   : Registration
    Created on : 14-Nov-2016, 14:15:11
    Author     : Sundas Choudry
--%>
 <%@ include file="/resources/GoogleAddressLookUp.jsp" %>
<div class="main">
    <div class="content-screen">
        <div class="title">
            <h1>Registration</h1>
        </div>
        <form class="form" name="login" action="${pageContext.request.contextPath}/Registration" method="post">
            <div class="input-label">
                <label>First Name</label>
            </div>
            <input class="control-group" type="text" name="firstName"  value=""  required>
            <div class="input-label">
                <label>Last Name</label>
            </div>
            <input class="control-group" type="text" name="lastName"  value="" required>
            <div class="input-label">
                <label>Date of Birth</label>
            </div>
            <input class="control-group" type="date" name="DOB"  value="" required>
            <div class="input-label">
                <label>Enter Your Full Address</label>
            </div>
            <input id="autocomplete"  placeholder="" onFocus="geolocate()" type="text">
            <div class="input-label">
                <label>No. &nbsp; &nbsp; &nbsp; &nbsp; Street Name</label>
            </div>
            <input class="houseNumber" name="houseNumber" id="street_number" disabled="true" required>
            <input class="streetname" name="streetName" id="route" disabled="true" required>
            <div class="input-label">
                <label>City</label>
            </div>
            <input class="control-group" name="city" id="locality" disabled="true" required>
            <div class="input-label">
                <label>Postcode</label>
            </div>
            <input class="control-group" name="postcode" id="postal_code" disabled="true" required>
            <div class="input-label">
                <label>Country</label>
            </div>
            <input class="control-group" name="country" id="country" disabled="true" >
            <input class="btn" type="submit" value="Submit">
            <input class="btn" type="reset" value="Reset">
            <!--Dispaly the error message-->
            <c:if test="${not empty post}">
                ${ErrorMessage}
            </c:if>
        </form>
    </div>
</div>