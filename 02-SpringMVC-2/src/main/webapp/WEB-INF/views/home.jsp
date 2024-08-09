<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>User Registration Form</h2>
	<form action="save" method="post">
		<label for="userName">User Name:</label><br> <input type="text"
			id="userName" name="userName" required><br>
		<br> <label for="address">Address:</label><br> <input
			type="text" id="address" name="address" required><br>
		<br> <label for="contact">Contact:</label><br> <input
			type="text" id="contact" name="contact" required><br>
		<br> <label for="password">Password:</label><br> <input
			type="password" id="password" name="password" required><br>
		<br> <input type="submit" value="Submit">
	</form>
</body>
</html>