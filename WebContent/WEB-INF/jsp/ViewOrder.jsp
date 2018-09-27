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

<h2>Order</h2>

<table width="400" border="solid 1px black">
   	<tr>
   		<th>Name</th>
   		<th>Price</th>
   		<th>Quantity</th>
   	</tr>
	<c:forEach items="${order.items}" var="item" varStatus="loop">
		<tr>
			<td><c:out value="${item.name}"></c:out></td>
			<td><c:out value="$ ${item.price}"></c:out></td>
			<td><c:out value="${item.quantity}"></c:out></td>
		</tr>
	</c:forEach>
</table>

<h2>Payment Information</h2>

<table width="600" border="solid 1px black">
	<tr>
		<th>Credit Card Number</th>
		<th>Expiration Date</th>
		<th>CVV Code</th>
		<th>Card Holder Name</th>
	</tr>
	<tr>
		<td><c:out value="${paymentInfo.creditCardNumber}"></c:out></td>
		<td><c:out value="${paymentInfo.expirationDate}"></c:out></td>
		<td><c:out value="${paymentInfo.cvvCode}"></c:out></td>
		<td><c:out value="${paymentInfo.cardHolderName}"></c:out></td>
	</tr>
</table>

<h2>Shipping Information</h2>

<table width="600" border="solid 1px black">
	<tr>
		<th>Name</th>
		<th>Address Line 1</th>
		<th>Address Line 2</th>
		<th>City</th>
		<th>State</th>
		<th>Zip</th>
	</tr>
	<tr>
		<td><c:out value="${shippingInfo.name}"></c:out></td>
		<td><c:out value="${shippingInfo.addressLine1}"></c:out></td>
		<td><c:out value="${shippingInfo.addressLine2}"></c:out></td>
		<td><c:out value="${shippingInfo.city}"></c:out></td>
		<td><c:out value="${shippingInfo.state}"></c:out></td>
		<td><c:out value="${shippingInfo.zip}"></c:out></td>
	</tr>
</table>


<form:form method="post" action="confirmOrder">
	<input type="submit" value="Confirm" />
</form:form>
</body>
</html>