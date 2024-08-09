<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>hello mvc</h1>

	<form action="register" method="post">
        <label for="userName">User Name:</label><br>
        <input type="text" id="userName" name="userName" required><br><br>
        
        <label for="userAddress">User Address:</label><br>
        <input type="text" id="userAddress" name="userAddress" required><br><br>
        
        <label for="userContact">User Contact:</label><br>
        <input type="tel" id="userContact" name="userContact" pattern="[0-9]{10}" required><br><br>
        
        <input type="submit" value="Submit">
    </form>
</body>

</html>