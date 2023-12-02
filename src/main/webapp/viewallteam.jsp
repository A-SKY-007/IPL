<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="special" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
${msg}
<h1>welcome to all team view page</h1>
<body>
<table border="1">
	<tr>
		<th>Team Id</th>
		<th>Team name</th>
		<th>Wallet</th>
		<th>status</th>
		<th>players</th>
		<th>Change status</th>
		<th>Add amount</th>
	</tr>
		<special:forEach var="team" items="${teams}">
		<tr>
		<th>${team.getTid()}</th>
		<th>${team.getName()}</th>
		<th>${team.getWallet()}</th>
		<th>${team.isStatus()}</th>
		<th><a href="viewplayers?id=${team.getTid()}"><button>View Players</button></a></th>
		<th><a href="changestatus?id=${team.getTid()}"><button>change_status</button></a></th>
		<th><a href="addammount.jsp?id=${team.getTid()}"><button>Add_ammount</button></a></th>
		</tr>
		</special:forEach>




</table>
</body>
</html>