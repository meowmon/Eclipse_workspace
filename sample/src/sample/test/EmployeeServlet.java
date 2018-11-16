package sample.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.handleRequest(req,resp);
	}

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.handleRequest(req,resp);
	}
	
	private void handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String language = req.getParameter("language1");
		String username = req.getParameter("username");
		String favSport = req.getParameter("favSport");
//		System.out.println("Name: " + name);
//		System.out.println("Age: " + age);
		
		Cookie sportCookie = new Cookie("favSport", favSport);
		sportCookie.setMaxAge(60*60*24);
		resp.addCookie(sportCookie);
		
		
		HttpSession session = req.getSession();
		
		try {
			session.setAttribute("username", username);
			resp.sendRedirect("employeeInfo.jsp?name="+name+"&age="+age+"&language="+language);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
