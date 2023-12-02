<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to signup page</h1>
<form action="signup"> <!-- I should always run this page only -->
	<h1>Choose your role</h1>
	<input type="radio" name="role" value="Management">Management <br><br>
	<input type="radio" name="role" value="team">Team <br><br>
	<input type="radio" name="role" value="player">Player <br><br>
	<button>Submit</button>
</form>
<br>
<a href="index.jsp">Already have an account</a>
</body>
</html>