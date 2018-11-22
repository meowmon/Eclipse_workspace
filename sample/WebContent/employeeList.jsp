<%@page import="sample.test.common.Constants"%>
<%@page import="sample.test.bean.EmployeeInfo"%>
<%@page import="java.util.List"%>
<%@page import="sample.test.dao.EmployeeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var deletedEmployees = "";
	function updateDeletedEmployees(id) {
		var checked = document.getElementById('ckb_'+id).checked;
		if(checked)
		{
			deletedEmployees = id;
		}
		else
		{
			deletedEmployees = '';
		}
		document.getElementById('deletedEmployees').value=deletedEmployees;
		
	}

	function deleteEmployees()
	{
		document.getElementById('frm').submit();
	}
</script>
</head>
<body>
	<a href="newEmployee.jsp?langugage=vi_VN">New Employee</a>
<%List<EmployeeInfo> employees = EmployeeDAO.getInstance().getEmployees(); %>

	<form id="frm" method="POST" action="employee?<%=Constants.ACTION%>=<%=Constants.ACTION_DELETE%>">
	<table cellpadding="2" cellspacing="2" border="1">
	<tr>
		<th>Name</th>
		<th>Age</th>
		<th>Sports</th>
		<th></th>
	</tr>
	<%
		
		for(EmployeeInfo e:employees)
		{
	%>
		<tr>
			<td><%=e.getName() %></td>
			<td><%=e.getAge() %></td>
			<td><%=e.getSports() %></td>
			
			<td><a href="employee?id=<%=e.getId() %>&<%=Constants.ACTION%>=<%=Constants.ACTION_DELETE%>">Delete</a></td>
			<td><input type="checkbox" value="<%=e.getId() %>" onchange="updateDeletedEmployees(<%=e.getId()%>)" id="ckb_<%=e.getId()%>"></td>
		</tr>
	
	<%
		}
	%>
	</table>
	<input type='hidden' name='id' id='deletedEmployees'/>
	<input type='button' value='Delete' onclick="deleteEmployees()"/>
	</form>
</body>
</html>

