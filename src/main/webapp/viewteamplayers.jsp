<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="special"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>Welcome to team players name</h1>
<h1>${msg}</h1>
<body>
	<%
	String msg = (String) request.getAttribute("msg");
	if (msg != null) {
	%>
	${msg}
	<%
	} else {
	%>
	<table border="1">
		<tr>
			<th>name
		</tr>
		<th>Role
		<th></th>

		<special:forEach var="player" items="${player}">

			<tr>
				<th>${player.getName()}
			</tr>
			<th>${player.getRole()}
			<th></th>


		</special:forEach>


	</table>


	<%
	}
	%>

</body>
</html>