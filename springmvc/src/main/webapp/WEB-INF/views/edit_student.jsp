<%@page import="edu.jspiders.springmvc.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	Student student = (Student) request.getAttribute("student");
	%>
	<div align="center">
		<form action="./update-student" method="post">
			<table>
				<tr>
					<td>Id</td>
					<td><input type="text" name="id" value="<%=student.getId()%>"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name"
						value="<%=student.getName()%>"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email"
						value="<%=student.getEmail()%>"></td>
				</tr>
				<tr>
					<td>Mobile</td>
					<td><input type="text" name="mobile"
						value="<%=student.getMobile()%>"></td>
				</tr>
				<tr>
					<td>Course</td>
					<td><input type="radio" name="course" value="DEVELOPEMENT">
						<label>Developement</label></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="radio" name="course" value="TESTING">
						<label>Testing</label></td>
				</tr>
			</table>
			<input type="submit" value="UPDATE">
		</form>
</body>
</html>