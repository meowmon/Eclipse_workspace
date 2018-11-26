package web.servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import web.bean.book;
import web.dao.ProductsDAO;
import web.common.Constants;

public class ProductServlet extends HttpServlet {
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
			String title = req.getParameter("title");
			String author= req.getParameter("author");
			String publishdate = req.getParameter("publishdate");
			book employee = new book(title,author,publishdate);
			ProductsDAO.getInstance().createBook(employee);
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
			ProductsDAO.getInstance().deleteBook(id);
			try {
				resp.sendRedirect("employeeList.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		throw new IllegalArgumentException("Invalid action.");
	}
}
