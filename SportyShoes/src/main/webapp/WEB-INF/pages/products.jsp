<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
	<div align='center'>
		<font color='green'>${successMessage}</font> <font color='red'>${errorMessage}</font>
	</div>
	<div align="center">
		<form method='post'>
			<fieldset class="form-group">
				Product Name : 
				<input name="prodName" type="text" class="form-control"
					required="required" value = "${productName}"/>
			</fieldset>
			
			<fieldset class="form-group">
				Category :
				<select name="prodCategory">
					<c:forEach items="${listCategory}" var="category">
						<option value="${category.catId}"
							<c:if test="${category.catId eq selectedCatId}">selected="selected"</c:if>>${category.catName}</option>
					</c:forEach>
				</select>
			</fieldset>
			<fieldset class="form-group">
				Product Stock : 
				<input name="prodStock" type="text" class="form-control"
					required="required" value = "${productStock}"/>
			</fieldset>
			<button type="submit" value="Add">Add Product</button>
			<br />
		</form>
	</div>

	<div class="container" align='center'>
		<table class="table table-striped">
			<caption>Categories</caption>
			<thead>
				<tr>
					<th>ID</th>
					<th>Product Name</th>
					<th>Product Stock</th>
					<th>Category Name</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${productList}" var="prod">
					<tr>
						<td>${prod.prodId}</td>
						<td>${prod.prodName}</td>
						<td>${prod.stock}</td>
						<td>${prod.prodCategory.catName}</td>
						<td><a type="button" class="btn btn-success"
							href="update-prod?id=${prod.prodId}">Update</a></td>
						<td><a type="button" class="btn btn-warning"
							href="delete-prod?id=${prod.prodId}">Delete</a></td>
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