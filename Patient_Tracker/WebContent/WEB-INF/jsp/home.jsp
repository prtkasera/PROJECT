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
<springform:form modelAttribute="admin" method="post" action="doLogin.htm">
<table>
<tr>
<td><springform:label path="adminId">Admin ID:</springform:label>
<td><springform:input path="adminId"/>
</td>
</tr>
<tr>
<td><springform:label path="adminPassword">Password:</springform:label>
<td><springform:input path="adminPassword"/>
</td>
</tr>
<tr>
<td><input type="submit" value="Login"></td>
</tr>
</table>
<springform:errors path="adminId" style="color:red"></springform:errors> 
</springform:form>

<form action="adminregistration.htm" method=post></form>
<input type="submit" value="Sign Up">



</body>
</html>