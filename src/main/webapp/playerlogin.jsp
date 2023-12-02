<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" isELIgnored="false"%> 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="UTF-8"> 
<title>Player Login</title> 
</head> 
<body> 
 
<h1> WELCOME TO PLAYER LOGIN PAGE</h1> 
<h1>${msg}</h1> 
 
<form action="playerlogin"> 
 
User_Name<input type="text" name="username" placeholder="Enter your name"><br><br>
Password<input type="text" name="password" placeholder="Enter your password"> <br><br>
 
<input type="submit"> 
<input type="reset"> 
 
 
</form> 
 
 
</body> 
</html>