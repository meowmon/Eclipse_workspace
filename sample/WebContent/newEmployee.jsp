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
	<form action="employee" method="POST" id='frmEmployee'>
		<table>
			<tr>
				<td>Name</td>
				<td><input name='name' id='name' type='text'></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input name='age' id='age' type='text'></td>
			</tr>
			<tr>
				<td><input type='button' value="Save" onclick="validate()" ></td>
				<td><input type='reset' value='Reset'/></td>
			</tr>
		</table>
	</form>
</body>
</html>