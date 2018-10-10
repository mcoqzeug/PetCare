<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation</title>
</head>
<body>
<div class="container">
	<jsp:include page="header.jsp"/>

	<div class="main">
		<div class="body">
			<h1>Confirmation</h1>
			<p>
				Your order has been submitted. <br>
				Your confirmation number is ${confirmationNum}.
			</p>
			<div>
				<form:form method="get" action="../purchase">
					<input type="submit" value="Make another order" />
				</form:form>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"/>
</div>

</body>
</html>