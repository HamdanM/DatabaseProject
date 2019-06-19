<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	Online Store
	<br> Enter username and password below
	<br>
	<br>

	<form action="ControlServlet" method="post">
		Enter username :<input type="text" name="username"> <br>
		Enter password :<input type="password" name="password"><br>
		<input type="submit" value="Login">
	</form>

</body>
</html>