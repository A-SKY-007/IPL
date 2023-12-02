<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h1>Wellcome_to_add_ammont_page</h1>
<body>
<% int id=Integer.parseInt(request.getParameter("id")); %>

<h1>Add_ammount</h1>
<form action="addammount">
Addammount :<input type="text" name="ammount" placeholder="Enter the ammount to be added">

<input type="text" name="id" value="<%=id%>" hidden="hidden"><br><br>

<button>Add_ammount</button> <button type="reset">Cancel</button>

</form>
</body>
</html>