<%@page import="sample.test.common.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
		function validate(){
			document.getElementById('frmEmployee').submit();
		}
	</script>
</head>
<body>
	<%
		String language = request.getParameter("langugage");
	%>
	<form action="employee?<%=Constants.ACTION%>=<%=Constants.ACTION_CREATE%>" method="POST" id='frmEmployee'>
		<table>
			<tr>
				<td>User name</td>
				<td><input name='username' id='username' type='text'></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input name='name' id='name' type='text'></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input name='age' id='age' type='text'></td>
			</tr>
			<tr>
				<td>Favorite sport</td>
				<td><input name='favSport' id='favSport' type='text'></td>
			</tr>
			<tr>
				<td><input type='button' value="Save" onclick="validate()" ></td>
				<td><input type='reset' value='Reset'/></td>
			</tr>
			
		</table>
		<input type="hidden" name="language1" value='<%=language%>'/>
	</form>
</body>
</html>