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
		Enter userID :<input type="text" name="userid"> <br>
		Enter username :<input type="text" name="username"> <br>
		Enter password :<input type="password" name="password"> <br>	
		Enter firstname :<input type="text" name="firstname"> <br>
		Enter lastname :<input type="text" name="lastname"> <br>
		Enter email :<input type="text" name="email"> <br>		
		Enter gender :<input type="" name="gender"> <br>
		Enter age :<input type="text" name="age"><br>
		<input type="submit" value="Login">
	</form>

</body>
</html>