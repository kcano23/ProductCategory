<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>     
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<a href="/">Home</a>
	<br>
	<div class="container">
		<h1>New Product</h1>
		<form:form action="/product/create" method="post" modelAttribute="product">
			<div class="form-group">
				<form:label path="name">Name:</form:label>
				<form:errors path="name"/>
				<form:input type="text" path="name" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="description">Description:</form:label>
				<form:errors path="description"/>
				<form:input type="text" path="description" class="form-control"/>
			</div>
			<div class="form-group">
				<form:label path="price">Price:</form:label>
				<form:errors path="price"/>
				<form:input type="number" path="price" class="form-control"/>
			</div>
			<div class="form-group">
				<input type="submit" value="Create"/>
			</div>
		</form:form>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name</th>
					<th scope="col">Description</th>
					<th scope="col">Price</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${allProducts}" var="product">
					<tr>
						<td>${product.id}</td>
						<td><a href="/product/${product.id}">${product.name}</a></td>
						<td>${product.description}</td>
						<td>${product.price}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
	</div>	
</body>
</html>