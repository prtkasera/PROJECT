<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@taglib uri="http://www.springframework.org/tags" prefix="springcore" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Admin</title>
</head>
<body>
<springform:form modelAttribute="adminRegModel" method="post" action="addadmin.htm">
<table>

<%-- <tr>
<td><springform:label path="adminId">Admin ID:</springform:label>
<td><springform:input path="adminId"/>
</tr>

 --%>
 <tr>
<td><springform:label path="firstName">First Name:</springform:label>
<td><springform:input path="firstName"/>
</tr>

<tr>
<td><springform:label path="lastName">Last Name:</springform:label>
<td><springform:input path="lastName"/>
</tr>

<tr>
<td><springform:label path="age">Age:</springform:label>
<td><springform:input path="age"/>
</tr>

 
<tr>
<td><springform:label path="gender">Gender:</springform:label></td>
<td>
	<springform:select path="gender">
	<springform:options items="${genderList}"/>
	
	</springform:select>
</td>	
</tr> 
 


<tr>
<td><springform:label path="dob">Date Of Birth:</springform:label>
<td><springform:input path="dob"/>
</tr>

<tr>
<td><springform:label path="contactNumber">Contact Number:</springform:label>
<td><springform:input path="contactNumber"/>
</tr>

<tr>
<td><springform:label path="alternateContactNumber">Alternate Contact Number</springform:label>
<td><springform:input path="alternateContactNumber"/>
</tr>

<tr>
<td><springform:label path="emailId">Email ID:</springform:label></td>
<td><springform:input path="emailId"/></td>
</tr>


<tr>
<td><springform:label path="adminPassword">Password</springform:label></td>
<td><springform:input path="adminPassword"/></td>
</tr>

<tr>
<td><input type="submit" value="Add Admin"></td>
</tr>
</table>
</springform:form>
${status}

<form method="post" action="login.htm">
<input type="submit" value="Login Page"/></form>
</body>
</html>