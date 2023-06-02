<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${updated}</h1>
	<form:form action="cityUpdated" modelAttribute="city2">
	
    City Name:<form:input path="name" />
		<br>
    City Food:<form:input path="food" />
		<br>
		<form:button>Update</form:button>
	</form:form>

</body>
</html>