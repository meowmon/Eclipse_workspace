<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Caculate</title>
	<script type="text/javascript">
		function validate(){
			document.getElementById('oneplusone').submit();
		}
	</script>
</head>
<body>
	<form action="caculate" method="POST" id="oneplusone">
		<table>
			<tr>
				<td>So thu nhat</td>
				<td>So thu hai</td>
			</tr>
			<tr>
				<td>
					<input name='num1' id='num1' type='text' >
				</td>
				<td>
					<input name='num2' id='num2' type='text' >
				</td>
			</tr>
			<tr>
				<td>
					<input type='button' value='Caculate' onclick="validate()">
					<td><input type='reset' value='Reset'/></td>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>