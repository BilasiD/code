<%@page import="jsp_student1.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIT</title>
</head>
<body>
<%Student  student=(Student)request.getAttribute("student"); %>
<form action="edit" method="post">
ID:<input type="number" name="id" value="<%=student.getId() %>" readonly="readonly">
<br>
<br>
Name:<input type="text" name="name" value="<%=student.getName() %>" required="required">
<br>
<br>
Email:<input type="text" name="email" value="<%=student.getEmail() %>" required="required">
<br>
<br>
Password:<input type="password" name="password" value="<%=student.getPassword() %>" required="required">
<br>
<br>
Address:<input type="text" name="address" value="<%=student.getAddress() %>" required="required">
<br>
<br>
PhoneNumaber:<input type="number" name="phone" value="<%=student.getPhoneno() %>" required="required">
<br>
<br>
<input type="submit" value="Edit">



</body>
</html>