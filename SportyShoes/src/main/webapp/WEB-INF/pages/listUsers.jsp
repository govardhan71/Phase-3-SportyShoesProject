<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ViewUsers</title>

</head>
<body>
	<div class="container" align = "center">
		<table class="table table-striped">
			<caption style='font:bold'>Users Registered are</caption>
			<thead>
				<tr>
					<th>User Name</th>
					<th>Email</th>
					<th>City</th>
					<th>Password</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			
				<c:forEach items="${userList}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.name}</td>
						<!--<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"/></td>  -->
						<td>${user.password}</td>
						<td>${user.city}</td>
						<td>${user.email}</td>
						<td><a type="button" class="btn btn-success"
							href="update-user?id=${user.id}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="delete-user?id=${user.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
	<div>
		<form method='get'>
			<a href='home'>Home</a>
		</form>
	</div>
	
</body>
</html>