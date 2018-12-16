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

<div class="main" align="center">
	<div class="body">
		<h1>About Us</h1>
		<table width="600">
			<tr>
				<th></th>
				<th>Name</th>
				<th>Role</th>
				<%-- <th>Education and Experience </th> --%>
			</tr>
			<tr>
				<td><img src="${pageContext.request.contextPath}/images/Juanxi.jpg" class="image" alt="Avatar"/></td>
				<td>Juanxi</td>
				<td>Co-founder</td>
				<%-- <td>A student at The Ohio State University
				<br> majoring in Computer Science and Engineering.</td> --%>
			</tr>
			<tr>
				<td><img src="${pageContext.request.contextPath}/images/Naveen.jpg" class="image" alt="Avatar"/></td>
				<td>Naveen</td>
				<td>CEO, Co-founder</td>
				<%-- <td>A student at The Ohio State University 
				<br> majoring in Computer Science and Engineering.</td> --%>
			</tr>
			<tr>
				<td><img src="${pageContext.request.contextPath}/images/Alberto.jpg" class="image" alt="Avatar"/></td>
				<td>Alberto</td>
				<td>Co-founder</td>
				<%-- <td>A student at The Ohio State University 
				<br> majoring in Computer Science and Engineering.</td> --%>
			</tr>
		</table>
	</div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>