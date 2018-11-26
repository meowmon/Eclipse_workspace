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
	<h1>this is Login</h1>
	<form action="log?<%=Utils.ACTION%>=<%=Utils.ACTION_LOGIN%>" method="post">
		<table>
			<tr>
				<td></td>
				<td>${message}</td>
			</tr>
			<tr>
				<td>UserName: </td>
				<td><input type="text" name="userName"/></td>
			</tr>
			<tr>
				<td>PassWord: </td>
				<td><input type="text" name="passWord"/></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="OK"/><input type="reset" value="Reset"/></td>
			</tr>
		</table>
	</form>

</body>
</html>