<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body>
<div class="container">
	<jsp:include page="header.jsp"/>

	<div class="main" align="center">
		<div class="body">
			<div>
				<h1>Payment Information</h1>
			</div>
			<form:form modelAttribute="paymentInfo" method="post" action="submitPayment">	
				<table width="400" align="center">
					<tr>
						<td><c:out value="Credit Card Number"></c:out></td>
						<td><form:input path="creditCardNumber" /></td>
					</tr>
					<tr>
						<td><c:out value="Expiration Date"></c:out></td>
						<td><form:input path="expirationDate" /></td>
					</tr>
					<tr>
						<td><c:out value="CVV Code"></c:out></td>
						<td><form:input path="cvvCode" /></td>
					</tr>
					<tr>
						<td><c:out value="Cardholder Name"></c:out></td>
						<td><form:input path="cardHolderName" /></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Submit"></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
	
	
	<jsp:include page="footer.jsp"/>
</div>
</body>
</html>