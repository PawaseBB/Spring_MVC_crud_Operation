<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Cities</title>
</head>
<body>
	<table border="1" style="border-collapse: collapse;">

		<tr>
			<th>ID</th>
			<th>City Name</th>
			<th>Famous Food</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<c:forEach var="city" items="${cities}">
			<tr>
				<td>${city.getId()}</td>
				<td>${city.getName()}</td>
				<td>${city.getFood()}</td>
				<td><a href="delete?id=${city.getId()}">Delete</a></td>
				<td><a href="update?id=${city.getId()}">Update</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>