<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="springcore" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
<springform:form modelAttribute="adminModel" method="post" action="doLogin.htm">
<table>
<tr>
<td><springform:label path="adminId">Admin ID:</springform:label>
<td><springform:input path="adminId"/>
<springform:errors path="adminId" style="color:red"></springform:errors>
</td>
</tr>
<tr>
<td><springform:label path="adminPassword">Password:</springform:label>
<td><springform:input path="adminPassword"/>
<springform:errors path="adminPassword" style="color:red"></springform:errors>
</td>
</tr>
<tr>
<td><input type="submit" value="Login"></td>
</tr>
</table>

</springform:form>

<form action="adminregistration.htm" method=post>
<input type="submit" value="Sign Up">
</form>


</body>
</html>