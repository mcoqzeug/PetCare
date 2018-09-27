<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="shippingInfo" method="post" action="submitShipping">
	<table>
		<tr>
			<td><c:out value="Name"></c:out></td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td><c:out value="Address Line 1"></c:out></td>
			<td><form:input path="addressLine1" /></td>
		</tr>
		<tr>
			<td><c:out value="Address Line 2"></c:out></td>
			<td><form:input path="addressLine2" /></td>
		</tr>
		<tr>
			<td><c:out value="City"></c:out></td>
			<td><form:input path="city" /></td>
		</tr>
		<tr>
			<td><c:out value="State"></c:out></td>
			<td><form:input path="state" /></td>
		</tr>
		<tr>
			<td><c:out value="ZIP"></c:out></td>
			<td><form:input path="zip" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit"></td>
		</tr>
	</table>
</form:form>
</body>
</html>