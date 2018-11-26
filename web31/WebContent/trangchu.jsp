<%@page import="web31.common.Utils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Well Come to WebServlet</h1>
	<a href="log?<%=Utils.ACTION%>=<%= Utils.ACTION_LOGOUT%>">Logout</a>
	<a href="ServletController?<%=Utils.ACTION%>=<%=Utils.ACTION_VIEW%>">List Book</a>
</body>
</html>