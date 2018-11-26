package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.handleRequest(req,resp);
	}

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.handleRequest(req,resp);
	}
	
	private void handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.print(username+' '+password);
		HttpSession session = req.getSession();
		if("admin".equals(username) && "admin".equals(password)) {
			try {
				resp.sendRedirect("productlist.jsp?username="+username);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				resp.sendRedirect("login.jsp?username="+username+"&login="+0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
