<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee info</title>
</head>
<body>
	Name: <%=request.getParameter("name") %><br/>
	Age: <%=request.getParameter("age") %>
</body>
</html>