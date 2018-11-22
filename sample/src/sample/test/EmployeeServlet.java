package sample.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sample.test.bean.EmployeeInfo;
import sample.test.common.Constants;
import sample.test.dao.EmployeeDAO;

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
		
		String action = req.getParameter(Constants.ACTION);
		if(Constants.ACTION_CREATE.equals(action))
		{
			String name = req.getParameter("name");
			int age = Integer.parseInt(req.getParameter("age"));
			String favSport = req.getParameter("favSport");
			EmployeeInfo employee = new EmployeeInfo(name,age,favSport);
			EmployeeDAO.getInstance().createEmployee(employee);
			try {
				resp.sendRedirect("employeeList.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		if(Constants.ACTION_DELETE.equals(action))
		{
			int id = Integer.valueOf(req.getParameter("id"));
			EmployeeDAO.getInstance().deleteEmployee(id);
			try {
				resp.sendRedirect("employeeList.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		throw new IllegalArgumentException("Invalid action.");
		
//		
//		String language = req.getParameter("language1");
//		String username = req.getParameter("username");
//		
////		System.out.println("Name: " + name);
////		System.out.println("Age: " + age);
//		
//		Cookie sportCookie = new Cookie("favSport", favSport);
//		sportCookie.setMaxAge(60*60*24);
//		resp.addCookie(sportCookie);
//		
//		
//		HttpSession session = req.getSession();
//		
//		try {
//			session.setAttribute("username", username);
//			resp.sendRedirect("employeeInfo.jsp?name="+name+"&age="+age+"&language="+language);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	

}
