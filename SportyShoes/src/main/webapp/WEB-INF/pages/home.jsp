<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align='center'>
		<font color='green'>${successMessage}</font> <font color='red'>${errorMessage}</font>
	</div>
	<div align='center'>
		<form method='get'>
			<a href='register'>AddUser</a>
		</form>
		<form method='get'>
			<a href='listUsers'>ListUsers</a>
		</form>
		<form method='get'>
			<a href='category'>Add Categories</a>
		</form>
		<form method='get'>
			<a href='manageProducts'>Manage Products</a>
		</form>
		<form method='get'>
			<a href='purchase'>Purchases</a>
		</form>
		<form method='get'>
			<a href='purchaseList'>Purchase Summary</a>
		</form>
			<form method='get'>
			<a href='changepass'>Change Password</a>
		</form>
	</div>
	<div>
		<form method='get'>
			<a href='Logout'>Logout</a>
		</form>
	</div>
</body>
</html>