<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>${msg}</h1>
<body>
<h1>Welcome to management login</h1>
<form action="managementlogin">
	Username:<input type="text" name="username" placeholder="Eneter your user name"><br><br>
	Password:<input type="text"  name="password" placeholder="Enetr your password"><br><br>
	
	<button>Submit</button>   	<button type="reset">Cancle</button>
</form>
</body>
</html>