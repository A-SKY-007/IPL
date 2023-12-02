<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="special"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>${msg}</h1>
<h1>welcome to all active player view page</h1>
<body>
	<table border="1">
		<tr>
			<th>Player Id</th>
			<th>Player name</th>
			<th>Role</th>
			<th>Price</th>
			<th>Status</th>
			<th>Buy</th>
		</tr>
		<special:forEach var="players" items="${players}">
			<tr>
				<th>${players.getId()}</th>
				<th>${players.getName()}</th>
				<th>${players.getRole()}</th>
				<th>${players.getPrice()}</th>
				<th>${players.getStatus()}</th>
				<th><a href=""><button>Buy</button></a></th>
			</tr>
		</special:forEach>



	</table>
</body>
</html>