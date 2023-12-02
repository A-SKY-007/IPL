<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>${msg}</h1>
<h1>welcome to team login</h1>
<body>
<form action="teamlogin" method="post">

	Username:<input type="text" name="username" placeholder="Enter your username"><br><br>
	Password:<input type="text" name="password" placeholder="Enter your password"><br><br>
	<button>login</button> 		<button type="reset">Cancle</button>
</form>
</body>
</html>