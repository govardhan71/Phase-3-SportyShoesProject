<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<div align='center'>
		<font color='green'>${successMessage}</font> <font color='red'>${errorMessage}</font>
	</div>
	<br />
	<div align="center">
		<form:form method="post" modelAttribute="user">
			<form:hidden path="id" />
			<fieldset class="form-group">
				<form:label path="name">User Name</form:label>
				<form:input path="name" type="text" class="form-control"
					required="required" />
				<form:errors path="name" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="password">PassWord</form:label>
				<form:input path="password" type="text" class="form-control"
					required="required" />
				<form:errors path="password" cssClass="text-warning" />
			</fieldset>

			

			<fieldset class="form-group">
				<form:label path="email">Email</form:label>
				<form:input path="email" type="text" class="form-control" />
				<form:errors path="email" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="city">City</form:label>
				<form:input path="city" type="text" class="form-control" />

				<form:errors path="city" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="adminAcc">Administrator Access</form:label>
				<form:checkbox path="adminAcc"  class="form-control" />
			</fieldset>

			<button type="submit" value="Register">Register</button>
			<br />
		</form:form>


	</div>
	<div>
		<form method='get'>
			<a href='home'>Home</a>
		</form>
	</div>
</body>
</html>