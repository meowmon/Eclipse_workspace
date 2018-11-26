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
	<h1>UPDATE BOOK</h1>
	<form action="ServletController?<%=Utils.ACTION%>=<%=Utils.ACTION_UPDATE%>" method="post">
		<table>
			<tr>
				<td>Id: </td>
				<td><%=request.getParameter("id")%><input type="hidden" id = "id" name = "id" value="<%=Integer.parseInt(request.getParameter("id"))%>"/></td>
			</tr>
			<tr>
				<td>Title: </td>
				<td><input type="text" name="title"/></td>
			</tr>
			<tr>
				<td>Author: </td>
				<td><input type="text" name="author"/></td>
			</tr>
			<tr>
				<td>PublishDate: </td>
				<td><input type="text" name="publishdate"/></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="OK" /><input type="reset" name="Reset" style="margin-left: 5px;"/></td>
			</tr>
		</table>
	</form>
</body>
</html>