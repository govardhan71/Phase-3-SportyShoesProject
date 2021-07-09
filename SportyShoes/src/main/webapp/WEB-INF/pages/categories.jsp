<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
</head>
<body>
	<div align='center'>
		<font color='green'>${successMessage}</font> <font color='red'>${errorMessage}</font>
	</div>
	<div align="center">
		<form:form method="post" modelAttribute="category">
			<form:hidden path="catId" />
			<fieldset class="form-group">
				<form:label path="catName">CategoryName</form:label>
				<form:input path="catName" type="text" class="form-control"
					required="required" />
				<form:errors path="catName" cssClass="text-warning" />
			</fieldset>
			<button type="submit" value="Add">Add Category</button>
			<br />
		</form:form>
	</div>

	<div class="container" align = 'center'>
		<table class="table table-striped">
			<caption>Categories</caption>
			<thead>
				<tr>
					<th>ID</th>
					<th>Category Name</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categories}" var="cat">
					<tr>
						<td>${cat.catId}</td>
						<td>${cat.catName}</td>
						<td><a type="button" class="btn btn-success"
							href="update-cat?id=${cat.catId}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="delete-cat?id=${cat.catId}">Delete</a></td>
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