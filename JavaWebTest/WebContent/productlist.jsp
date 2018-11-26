<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="web.common.Constants"%>
<%@page import="web.bean.book"%>
<%@page import="java.util.List"%>
<%@page import="web.dao.ProductsDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products list</title>
<script type="text/javascript">
	var deletedBook = "";

	function deleteEmployees()
	{
		document.getElementById('frm').submit();
	}
</script>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<%List<book> books = ProductsDAO.getInstance().getBook(); %>

	<form id="frm" method="POST" action="product?<%=Constants.ACTION%>=<%=Constants.ACTION_DELETE%>">
	<table cellpadding="2" cellspacing="2" border="1">
	<tr>
		<th>Title</th>
		<th>Author</th>
		<th>Publish Date</th>
		<th></th>
	</tr>
	<%
		
		for(book e:books)
		{
	%>
		<tr>
			<td><%=e.getTitle() %></td>
			<td><%=e.getAuthor() %></td>
			<td><%=e.getPublishdate() %></td>
			
			<td><a href="product?id=<%=e.getId() %>&<%=Constants.ACTION%>=<%=Constants.ACTION_DELETE%>">Delete</a></td>
			
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