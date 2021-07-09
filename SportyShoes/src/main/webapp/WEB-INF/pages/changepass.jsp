<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<div align='center'>
		<font color='green'>${successMessage}</font> <font color='red'>${errorMessage}</font>
	</div>
	<div align="center">
		<form method='post'>
			<fieldset class="form-group">
				Old Password : 
				<input name="oldpass" type="text" class="form-control"
					required="required" />
			</fieldset>
			<fieldset class="form-group">
				New Password : 
				<input name="NewPass" type="text" class="form-control"
					required="required" />
			</fieldset>
				<fieldset class="form-group">
				Confirm Password : 
				<input name="confPass" type="text" class="form-control"
					required="required" />
			</fieldset>
			<button type="submit" value="Add">Change Password</button>
			<br />
		</form>
	</div>
	<div>
		<form method='get'>
			<a href='home'>Home</a>
		</form>
	</div>
</body>
</html>