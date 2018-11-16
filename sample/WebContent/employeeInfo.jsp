<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee info</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
	String favSport = "";
	for(Cookie cookie:cookies)
	{
		if(cookie.getName().equals("favSport"))
		{
			favSport = cookie.getValue();
			break;
		}
	}
%>
	User name: <%=session.getAttribute("username") %><br/>
	Name: <%=request.getParameter("name") %><br/>
	Age: <%=request.getParameter("age") %><br/>
	Language: <%=request.getParameter("language") %><br/>
	Favorite sport: <%=favSport %>
</body>
</html>