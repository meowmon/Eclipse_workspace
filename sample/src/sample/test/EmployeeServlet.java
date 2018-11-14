package sample.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		
		try {
			resp.sendRedirect("employeeInfo.jsp?name="+name+"&age="+age);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
