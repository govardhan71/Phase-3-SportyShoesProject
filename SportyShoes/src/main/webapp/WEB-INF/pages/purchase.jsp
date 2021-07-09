<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase</title>
</head>
<body>
	<div align='center'>
		<font color='green'>${successMessage}</font> <font color='red'>${errorMessage}</font>
	</div>
	<div align="center">
		<form method='post'>
			<fieldset class="form-group">
				Product :
				<select name="product">
					<c:forEach items="${listProduct}" var="product">
						<option value="${product.prodId}">${product.prodName}</option>
					</c:forEach>
				</select>
			</fieldset>
			<fieldset class="form-group">
				Purchase Count : 
				<input name="purchaseCount" type="text" class="form-control"
					required="required"/>
			</fieldset>
			<button type="submit" value="Add">Buy Product</button>
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