
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Details</title>
</head>
<body>

<table>
<tr>
<th>Patient Id</th>
<th>Patient First Name</th>
<th>Patient Last Name </th>
<th>Patient Age</th>
<th>Patient Date OF Birth</th>
</tr>
<c:forEach items="${patientList}" var="patient">
<tr>
<td><c:out value="${pateint.patientId}"/></td>
<td><c:out value="${patient.firstName}"/></td>

<td><c:out value="${patient.lastName}"/></td>
<td><c:out value="${patient.age}"/></td>
<td><c:out value="${patient.dob}"/></td>
</tr>

</c:forEach>
</table>
<form method="get" action="addPatient.htm">
<input type="submit" value="Add Patient"/>
</form>
</body>
</html>