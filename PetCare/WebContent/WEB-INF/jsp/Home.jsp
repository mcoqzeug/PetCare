<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PetCare Home</title>
</head>
<body>
<div class="container">
	<jsp:include page="header.jsp"/>

	<div class="main" align="center">
		<div class="body">
			<div>
				<img src="${pageContext.request.contextPath}/images/home.jpg" class="homeImage"/>
			</div>
			<div>
				<h1>Our Vision</h1>
				<p>
					Quality and satisfaction to customers with their pets.
				</p>
			</div>
			<div>
				<h1>Our Strategy</h1>
				<p>
					Continuously strive for excellent service and customer satisfaction.
				</p>
			</div>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"/>
</div>

</body>
</html>
