<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mystyle.css"> -->
<title>Make Order</title>
</head>
<body>

<div class="container">
	<jsp:include page="header.jsp"/>

	<div class="main">
		<div class="body">
			<form:form modelAttribute="order" method="post" action="purchase/submitItems">
			<table>
				<tr>
					<td>Name</td>
					<td>Price</td>
					<td>Quantity</td>
				</tr>
			<c:forEach items="${order.lineItems}" var="lineItem" varStatus="loop">
				
				<tr>
					<td><c:out value="${lineItem.itemName}"></c:out></td>
					<form:input type="hidden" path="lineItems[${loop.index}].itemName"/>
					<td><c:out value="$ ${lineItem.price}"></c:out></td>
					<form:input type="hidden" path="lineItems[${loop.index}].price"/>
					<td><form:input path="lineItems[${loop.index}].quantity" /></td>
				</tr>
			</c:forEach>
				<tr>
					<td colspan="2"><input type="submit" value="Purchase"></td>
				</tr>
			</table>
			</form:form>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"/>
</div>

</body>
</html>