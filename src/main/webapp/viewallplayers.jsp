<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="special"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h1>Wellcome_to_view_all_players</h1>
<h1>${msg}</h1>
<body>
	<table border="1">
		<tr>
			<th>Player_name</th>
			<th>Role</th>
			<th>Base_price</th>
			<th>status</th>
			<th>change_status</th>
		</tr>
		<special:forEach var="player" items="${players}">

		<tr>
			<th>${player.getName()}</th>
			<th>${player.getRole()}</th>
			<th>${player.getPrice()}</th>
			<th>${player.getStatus()}</th>
			<th><a href="changeplayerstatus?id=${player.getId()}"><button>change_status</button></a></th>

		</tr>
		</special:forEach>

	</table>
</body>
</html>