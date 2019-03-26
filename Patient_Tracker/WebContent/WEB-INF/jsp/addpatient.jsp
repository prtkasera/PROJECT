<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@taglib uri="http://www.springframework.org/tags" prefix="springcore" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Patient</title>
</head>
<body>
<springform:form modelAttribute="patient" method="get" action="addpatient.htm">
<table>

<tr>
<td><springform:label path="patientId">Patient ID:</springform:label>
<td><springform:input path="patientId"/>
</tr>

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
<td><springform:label path="gender">Gender:</springform:label>
<td><springform:input path="gender"/>
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
<td><springform:label path="addressLine1">Address Line1:</springform:label></td>
<td><springform:input path="addressLine1"/></td>
</tr>

<tr>
<td><springform:label path="addressLine2">Address Line2:</springform:label></td>
<td><springform:input path="addressLine2"/></td>
</tr>

<tr>
<td><springform:label path="city">City:</springform:label></td>
<td><springform:input path="city"/></td>
</tr>

<tr>
<td><springform:label path="state">State:</springform:label></td>
<td><springform:input path="state"/></td>
</tr>

<tr>
<td><springform:label path="zipCode">Zip Code:</springform:label></td>
<td><springform:input path="zipCode"/></td>
</tr>

<tr>
<td><input type="submit" value="Add Product"></td>
</tr>
</table>

</springform:form>
${status}

<form action="viewpatients.jsp" method="get">
<input type="submit" value="View Patients"/></form>
</body>
</html>