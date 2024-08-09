<%@page import="com.nebula.entity.User"%>
<%@page import="java.util.List"%>
<%@page import="com.nebula.service.UserService"%>
<%@page import="org.springframework.ui.Model"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Success</title>
</head>
<body>
    <h1>Registration Successful</h1>
    <table border="1">
        <thead>
            <tr>
                <th>User ID</th>
                <th>User Name</th>
                <th>Address</th>
                <th>Contact</th>
                <th>Password</th>
                <th>action</th>
                <th>action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="all" items="${all}">
                <tr>
                    <td>${all.userId}</td>
                    <td>${all.userName}</td>
                    <td>${all.address}</td>
                    <td>${all.contact}</td>
                    <td>${all.password}</td>
                    <td><a href="delete/${all.userId }">delete</a>
                    <td><a href="update/${all.userId }">update</a>
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
