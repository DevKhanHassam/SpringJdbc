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
	<h1>Hello World</h1>


	<div align="center">
		<table border="1">

			<tr bgcolor="lightgrey">
				<th>RollNo</th>
				<th>Name</th>
				<th>Address</th>
			</tr>
			<c:forEach var="student" items="${studentList}">

				<tr>
					<td>${student.rollNo}</td>
					<td>${student.studentName}</td>
					<td>${student.studentAddress}</td>
					<td> <button><a href="${pageContext.request.contextPath}/updateStudent?rollno=${student.rollNo}">Update</a></button></td>
				</tr>


			</c:forEach>
		</table>
		
		
	  <button><a href="addStudent">ADD Student</a></button>
	  
	  <form:form action="deleteStudent" method="post" modelAttribute="dtoStudent"  >
	  
	  	<label>delete id</label>
	  	<form:input path="id"/>
	  	<input type="submit" value="submit">
	  </form:form>
	 
	</div>

	<p></p>
</body>
</html>