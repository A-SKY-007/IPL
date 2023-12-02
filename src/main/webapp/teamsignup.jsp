<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="special" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<h1>welcome to team sign up page</h1>
<body>
		<special:form action="teamsignup" modelAttribute="team">
			
			Name:<special:input path="name"/><br><br>
			Username:<special:input path="username"/><br><br>
			Password:<special:input path="password"/><br><br>
			Wallet:<special:input path="wallet"/><br><br>
		
		<special:button>Singnup</special:button> <special:button type="reset">Cancal</special:button><br><br>
	</special:form>
</body>
</html>