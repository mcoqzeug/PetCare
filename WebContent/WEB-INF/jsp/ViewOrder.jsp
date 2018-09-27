<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Order</title>
</head>
<body>

<h1>View Order</h1>

<h2>Order Information</h2>

<table>
	<tr>
		<th>Name</th>
		<th>Price</th>
		<th>Quantity</th>
	</tr>
<c:forEach items="${order.items}" var="item" varStatus="loop">
	<c:if test="${Integer.parseInt(item.quantity) > 0}">
	<tr>
		<td><c:out value="${item.name}"></c:out></td>
		<td><c:out value="$ ${item.price}"></c:out></td>
		<td><c:out value="${item.quantity}"></c:out></td>
	</tr>
	</c:if>
</c:forEach>
</table>

<h2>Payment Information</h2>

<table>
	<tr>
		<td>Credit Card Number</td>
		<td><c:out value="${paymentInfo.creditCardNumber}"></c:out></td>
	</tr>
	<tr>
		<td>Expiration Date</td>
		<td><c:out value="${paymentInfo.expirationDate}"></c:out></td>
	</tr>
	<tr>
		<td>CVV Code</td>
		<td><c:out value="${paymentInfo.cvvCode}"></c:out></td>
	</tr>
	<tr>
		<td>Cardholder Name</td>
		<td><c:out value="${paymentInfo.cardHolderName}"></c:out></td>
	</tr>
</table>

<h2>Shipping Information</h2>

<table>
	<tr>
		<td>Name</td>
		<td><c:out value="${shippingInfo.name}"></c:out></td>
	</tr>
	<tr>
		<td>Address</td>
		<td><c:out value="${shippingInfo.addressLine1}"></c:out></td>
	</tr>
	<tr>
		<td></td>
		<td><c:out value="${shippingInfo.addressLine2}"></c:out></td>
	</tr>
	<tr>
		<td>City</td>
		<td><c:out value="${shippingInfo.city}"></c:out></td>
	</tr>
	<tr>
		<td>State</td>
		<td><c:out value="${shippingInfo.state}"></c:out></td>
	</tr>
	<tr>
		<td>ZIP</td>
		<td><c:out value="${shippingInfo.zip}"></c:out></td>
	</tr>
</table>

<form:form method="post" action="confirmOrder">
	<input type="submit" value="Confirm" />
</form:form>
</body>
</html>