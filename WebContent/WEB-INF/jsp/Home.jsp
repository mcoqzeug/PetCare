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

	<div class="main">
		<div class="body">
			<div>
				<h2>Our Vision</h2>
				<p>
					Quality and satisfaction to customers with their pets.
				</p>
			</div>
			<div>
				<h2>Our Strategy</h2>
				<p>
					Continuously Strive for excellent Service and customer Satisfaction
				</p>
			</div>

			<table>
				<tr>
					<th> Product </th>
					<th> Cost </th>
				</tr>
				<tr>
					<td> Dry cat Food </td>
					<td> 50$ </td>
				</tr>
				<tr>
					<td> Wet Cat Litter  </td>
					<td> 20$ </td>
				</tr>
				<tr>
					<td> Cat Litter </td>
					<td> 35$ </td>
				</tr>
			</table>
			
		</div>
	</div>
	
	<jsp:include page="footer.jsp"/>
</div>

</body>
</html>
