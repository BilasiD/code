<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<title>SIGNUP</title>
<body>
<%String message=(String)request.getAttribute("message"); %>
<%if(message!=null){ %>
<%=message %>
<%} %>
<form action="signup" method="post">
ID:<input type="number" name="id">
<br>
<br>
Name:<input type="text" name="name">
<br>
<br>
Email:<input type="text" name="email">
<br>
<br>
Password:<input type="password" name="password">
<br>
<br>
Address:<input type="text" name="address">
<br>
<br>
PhoneNumaber:<input type="number" name="phoneno">
<br>
<br>
<input type="submit" value="SIGNUP">
</form>
</body>
</html>
</body>
</html>
