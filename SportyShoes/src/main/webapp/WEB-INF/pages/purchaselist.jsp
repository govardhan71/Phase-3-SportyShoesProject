
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
	$(function() {
		$('#date').datepicker({
			format : 'dd/MM/yyyy'
		});
	});
</script>
</head>
<body>
	<div align="center">
		<form method='post'>
			<fieldset class="form-group">
				User : <select name="username">
					<c:forEach items="${listUsers}" var="user">
						<option value="${user.id}">${user.name}</option>
					</c:forEach>
				</select>
			</fieldset>
			<fieldset class="form-group">
				Product Category : <select name="productCategory">
					<c:forEach items="${listCategory}" var="cat">
						<option value="${cat.catId}">${cat.catName}</option>
					</c:forEach>
				</select>
			</fieldset>
			<fieldset class="form-group">
				Purchase Date: <input id="date" placeholder='dd/MM/yyyy'
					name="purchaseDate" type="text" class="form-control" />
			</fieldset>
			<button type="submit" value="Add">Fetch Purchases</button>
			<br />

		</form>
	</div>

	<div class="container" align='center'>
		<table class="table table-striped">
			<caption>Purchase</caption>
			<thead>
				<tr>
					<th>ID</th>
					<th>Product Name</th>
					<th>User</th>
					<th>Purchase Count</th>
					<th>Date</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${purchaseList}" var="pur">
					<tr>
						<td>${pur.purchaseId}</td>
						<td>${pur.purchase.prodName}</td>
						<td>${pur.user.name}</td>
						<td>${pur.purchaseCount}</td>
						<td>${pur.date}</td>
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