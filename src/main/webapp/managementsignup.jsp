<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="special" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to management signup</h1>
	<special:form action="managementsignup" modelAttribute="management">
	
		Username:<special:input path="username"/><br><br>
		Password:<special:input path="password"/><br><br>
		
		<special:button>Singnup</special:button> <special:button type="reset">Cancal</special:button><br><br>
	</special:form>
</body>
</html>