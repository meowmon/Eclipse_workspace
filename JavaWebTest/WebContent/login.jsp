<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login</title>
	<script type="text/javascript">
		function validate(){
			document.getElementById('frmLogin').submit();
		}
	</script>
</head>
<body>
<form action="login" method="POST" id='frmLogin'>
	<table>
		<tr>
			<td>Username</td>
			<td>Password</td>
		</tr>
		<tr>
			<td><input name='username' id='username' type='text'></td>
			<td><input name='password' id='password' type='password'></td>
			
		</tr>
		<% 
			if("0".equals(request.getParameter("login"))){
		%>
		<tr>
			<td bgcolor="red" colspan="2"> Username or password missmatch </td>
		</tr>
		<%} %>
		<tr>
			<td><input type='button' value="Login" onclick="validate()" ></td>
			<td><input type='reset' value='Reset'/></td>
		</tr>
	</table>
</form>

</body>
</html>