<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>     
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<a href="/">Home</a>
	<br>
	<h1>${showProduct.name}</h1>

	<h2>${showProduct.description}</h2>
	<h2>${showProduct.price}</h2>
	<ul>
		<c:forEach items="${showProduct.categories}" var="cat">
			<li>${cat.name}</li>
		</c:forEach>
	</ul>

	<form action="/addCategory" method="post">
		<input type="hidden" name="hiddenProdId" value="${showProduct.id}">
		<label for="">Add Category</label>
		<select name="selectedCat" id="">
			<c:forEach items="${allCategories}" var="cat">
				<option value="${cat.id}">${cat.name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Add">
	</form>
</body>
</html>