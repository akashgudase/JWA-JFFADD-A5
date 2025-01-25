<%@page import="edu.jspiders.springmvc.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All students page</title>
<style type="text/css">
/* Global styles */
body {
	font-family: 'Arial', sans-serif;
	background: #f4f7fc;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

/* Container styling */
div {
	background-color: #fff;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
	padding: 40px 60px;
	border-radius: 10px;
	width: 100%;
	max-width: 900px;
	text-align: center;
}

/* Table Styling */
table {
	width: 100%;
	margin-top: 20px;
	border-collapse: collapse;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
	overflow: hidden;
}

/* Table header */
th {
	background-color: #4CAF50;
	color: white;
	padding: 12px;
	font-size: 16px;
	text-align: left;
}

/* Table data */
td {
	background-color: #f9f9f9;
	color: #333;
	padding: 12px;
	font-size: 14px;
	text-align: left;
	border-bottom: 1px solid #ddd;
}

td a {
	color: #4CAF50;
	text-decoration: none;
	font-weight: bold;
	margin-right: 15px;
	transition: color 0.3s ease;
}

td a:hover {
	color: #45a049;
}

/* Alternating row colors */
tr:nth-child(even) td {
	background-color: #f2f2f2;
}

/* Add hover effect on rows */
tr:hover td {
	background-color: #e0f7fa;
}

/* Message styling */
h4 {
	font-size: 16px;
	color: #d32f2f;
	margin-top: 20px;
}

/* Responsive design */
@media screen and (max-width: 768px) {
	div {
		padding: 30px 40px;
		width: 90%;
	}
	table {
		font-size: 12px;
	}
	th, td {
		padding: 10px;
	}
	td a {
		font-size: 12px;
		margin-right: 10px;
	}
}

@media screen and (max-width: 480px) {
	div {
		padding: 20px 30px;
		width: 95%;
	}
	table {
		font-size: 10px;
	}
	th, td {
		padding: 8px;
	}
	td a {
		font-size: 10px;
		margin-right: 8px;
	}
}
</style>
</head>
<body>
	<div align="center">
		<%
		Student s = (Student) request.getAttribute("student");
		if (s != null) {
		%>
		<table>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Course</th>
				<th colspan="2">Action</th>
			</tr>
			<tr>
				<td><%=s.getName()%></td>
				<td><%=s.getEmail()%></td>
				<td><%=s.getMobile()%></td>
				<td><%=s.getCourse()%></td>
				<td><a href="edit-student?id=<%=s.getId()%>">Edit</a></td>
				<td><a href="delete-student?id=<%=s.getId()%>">Delete</a></td>
			</tr>
		</table>
		<%
		}
		%>
		<%
		@SuppressWarnings("unchecked")
		List<Student> students = (List<Student>) request.getAttribute("students");
		if (students != null) {
		%>
		<table>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Course</th>
				<th colspan="2">Action</th>
			</tr>
			<%
			for (Student student : students) {
			%>
			<tr>
				<td><%=student.getName()%></td>
				<td><%=student.getEmail()%></td>
				<td><%=student.getMobile()%></td>
				<td><%=student.getCourse()%></td>
				<td><a href="edit-student?id=<%=student.getId()%>">Edit</a></td>
				<td><a href="delete-student?id=<%=student.getId()%>">Delete</a></td>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>

		<%
		String message = (String) request.getAttribute("message");
		if (message != null) {
		%>
		<h4><%=message%></h4>
		<%
		}
		%>
		<a href="home" style="text-decoration: none;">Back to Home</a>
	</div>
</body>
</html>