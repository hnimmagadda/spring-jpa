<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Marks</title>
</head>
<body>
<h2>Update Marks Details</h2>
<form action="updatemarks" method="post">
<h2> updating student information of Id"<%=request.getParameter("stid") %></h2>
Exid:<input type="text" name="exid"><br>
Stid:<input type="text" name="stid" value="<%=request.getParameter("stid") %>" readonly="readonly"><br>
sub1:<input type="text" name="sub1"><br>
sub2:<input type="text" name="sub2"><br>
sub3:<input type="text" name="sub3"><br>
<input type="submit" value="submit">&emsp;
<input type="reset" value="cancel">
</form>
</body>
</html>