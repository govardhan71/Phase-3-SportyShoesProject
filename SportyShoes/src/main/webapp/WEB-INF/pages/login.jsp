<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align = 'center'>
		<font color='red'>${errorMessage}</font>
	</div><br />
	<div align = 'center'>
		<form method="post">
			User Name : <input type="text" name="uname" /> <br /><br /> Password : <input
				type="password" name="upass" /> <br /><br />
			<button type="submit" value="login">Login</button>
		</form>
	</div>
</body>
</html>