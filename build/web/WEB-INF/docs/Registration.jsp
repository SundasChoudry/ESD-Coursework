<%-- 
    Document   : Registration
    Created on : 14-Nov-2016, 14:15:11
    Author     : Sundas Choudry
--%>

<div class="main">
    <div class="content-screen">
        <div class="title">
            <h1>Registration</h1>
        </div>
        <form class="form" name="login" action="${pageContext.request.contextPath}/Registration" method="post">
            <input class="control-group" type="text" name="name"  value="" placeholder="Name" required>
            <input class="control-group" type="text" name="address"  value="" placeholder="Address" required>
            <input class="control-group" type="date" name="DOB"  value="" placeholder="Date of Birth" required>
            <input class="btn" type="submit" value="Submit">
            <input class="btn" type="reset" value="Reset">
        </form>
    </div>
</div>
