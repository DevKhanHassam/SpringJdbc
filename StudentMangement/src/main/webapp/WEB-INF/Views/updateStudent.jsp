<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Update student Record</h1>

<form:form action="saveData" method="post" modelAttribute="dtoStudent" >

		<div>
		<label>Student RollNo</label>
		<form:input id="id" path="id"/>
		</div>
		<br>
		<div>
		<label>Student Name</label>
		<form:input id="name" path="name"/>
		</div>
		<br>
		<div>
		<label>Student Address</label>
		<form:input id="address" path="address"/>
		</div>
		<br>
		<div>
		<input type="submit" value="Update">
		</div>
		



</form:form>


</body>
</html>