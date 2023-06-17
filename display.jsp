<%@page import="java.util.List"%>
<%@page import="jsp_student1.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>display</title>
</head>
<body>
<%List<Student> students=(List)request.getAttribute("list"); %>
<table border="2px">
<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Address</th>
<th>Phone</th>
<th>Fees</th>
<th>Delete</th>
<th>Update</th>
</tr>
<%for(Student student:students) {%>
<tr>
<td><%=student.getId() %></td>
<td><%=student.getName() %></td>
<td><%=student.getEmail() %></td>
<td><%=student.getPassword() %></td>
<td><%=student.getAddress() %></td>

<td><%=student.getPhoneno() %></td>
<td><%=student.getFees() %></td>
<td><a href="delete?id=<%=student.getId() %>">Delete</a></td>
<td><a href="update?id=<%=student.getId() %>">Update</a></td>
</tr>

<%} %>

</table>

</body>
</html>