<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About Us</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="main">
	<div class="body">
		<h1>About Us</h1>
		<table>
			<tr>
				<th></th>
				<th>Name</th>
				<th>Job Title</th>
				<th>Education and Experience </th>
			</tr>
			<tr>
				<td ><img src="${pageContext.request.contextPath}/images/Juanxi_Photo.jpg" class="image" alt="Avatar"/></td>
				<td>Juanxi</td>
				<td>Cofounder, Software Developer</td>
				<td>A master student at The Ohio State University majoring in Computer Science and Engineering.</td>
			</tr>
			<tr>
					<td ><img src="${pageContext.request.contextPath}/images/Naveen_Photo.jpg" class="image" alt="Avatar"/></td>
					<td>Naveen</td>
					<td>Cofounder, Software Developer</td>
					<td>A master student at The Ohio State University majoring in Computer Science and Engineering.</td>
				</tr>
		</table>
	</div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>