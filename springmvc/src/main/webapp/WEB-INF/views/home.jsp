<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
<style type="text/css">
/* Resetting some default styles */
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	font-family: 'Arial', sans-serif;
	background-color: #f4f7fc;
	color: #333;
	line-height: 1.6;
}

/* Navigation Bar */
nav {
	background-color: #2c3e50;
	display: flex;
	justify-content: center;
	padding: 15px 0;
}

nav a {
	color: #ecf0f1;
	font-size: 18px;
	text-decoration: none;
	padding: 10px 20px;
	margin: 0 15px;
	transition: all 0.3s ease;
}

nav a:hover {
	background-color: #66cc66;
	color: #fff;
	border-radius: 5px;
}

/* Main Section */
div {
	text-align: center;
	padding: 50px 20px;
}

h1 {
	font-size: 36px;
	color: #34495e;
	margin-bottom: 20px;
	text-transform: uppercase;
}

p {
	font-size: 18px;
	line-height: 1.7;
	color: #7f8c8d;
	max-width: 800px;
	margin: 0 auto;
	padding: 0 15px;
}

/* Button Styles for Links */
a {
	display: inline-block;
	text-decoration: none;
	padding: 12px 25px;
	background-color: #4CAF50;
	color: #fff;
	border-radius: 30px;
	font-size: 16px;
	margin: 10px 0;
	transition: all 0.3s ease;
}

a:hover {
	background-color: #2980b9;
}

/* Responsive Design */
@media ( max-width : 768px) {
	h1 {
		font-size: 28px;
	}
	p {
		font-size: 16px;
	}
	nav {
		flex-direction: column;
	}
	nav a {
		margin: 10px 0;
	}
}
</style>
</head>
<body>
	<nav>
		<a href="add-student-page">Add Student</a> <a href="students">All
			Students</a> <a href="">Edit Account</a> <a href="">Delete Account</a> <a
			href="logout">Logout</a>
	</nav>
	<div align="center">
		<h1>WELCOME TO WEB BLOGGER</h1>
		<p>Student Management System is a user-friendly platform that
			allows you to create and manage student details effortlessly. With
			customizable templates and an intuitive interface, you can manage and
			maintain student data. Developed by JWA-JFFADD-A5 group of developers
			with a vision to empower every user in every part of India to benefit
			from digital India and make in India revolution.</p>
	</div>
</body>
</html>