<%@page import="web31.common.Utils"%>
<%@page import="web31.entity.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List Book</h1>
	<a href="log?<%=Utils.ACTION%>=<%= Utils.ACTION_LOGOUT%>">Logout</a>
	
	<%
		List<Book> listbook = (List<Book>) request.getAttribute("listbook");
	%>
	<table border="1" width="60%">
		<tr>
			<th>Id</th>
			<th>Title</th>
			<th>Author</th>
			<th>PublishDate</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
	<%
		for(Book book: listbook){
	%>
		<tr>
			<td><%=book.getId()%></td>
			<td><%=book.getTitle()%></td>
			<td><%=book.getAuthor()%></td>
			<td><%=book.getPublishDate()%></td>
			
			<td><a href="updateBook.jsp?id=<%=book.getId()%>">update</a></td>
			<td><a href="ServletController?id=<%=book.getId()%>&<%=Utils.ACTION%>=<%=Utils.ACTION_DELETE%>">delete</a></td>
		</tr>
	<%} %>
	</table>
	<div style="font-size: 15px;">
			<a style="color: #800000" href="addBook.jsp">Add Employee</a>
		</div>
</body>
</html>