package caculate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaculateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handleRequest(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		handleRequest(req, resp);
		
	}
	private void handleRequest(HttpServletRequest req, HttpServletResponse resp) {
		String num1 = req.getParameter("num1");
		String num2 = req.getParameter("num2");
		System.out.println("num1: " + num1);
		System.out.println("num2: " + num2);
		int result = Integer.parseInt(num1) + Integer.parseInt(num2);
		try {
			resp.sendRedirect("caculated.jsp?result="+result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
