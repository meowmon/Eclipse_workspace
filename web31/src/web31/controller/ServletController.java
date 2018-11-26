package web31.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import web31.common.Utils;
import web31.entity.Book;
import web31.service.BookService;


public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handServlet(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		handServlet(request, response);
	}


	private void handServlet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		Logger logging = Logger.getLogger(ServletController.class);
		String action = request.getParameter(Utils.ACTION);
		
		
		if(Utils.ACTION_ADD.equals(action)){
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String publishdate = request.getParameter("publishdate");
			
			Book book = new Book();
			book.setTitle(title);
			book.setAuthor(author);
			book.setPublishDate(publishdate);
			
			int status = BookService.getInstance().addBook(book);
			
			if(status > 0){
				logging.info("Add Successfully");
				response.sendRedirect("ServletController?action="+Utils.ACTION_VIEW);
			}else {
				String message = "add failed!";
				request.setAttribute("message", message);
				RequestDispatcher rd = request.getRequestDispatcher("/addBook.jsp");
				rd.forward(request, response);
			}
		}
		if(Utils.ACTION_UPDATE.equals(action)){
			
			int id = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			String publishdate = request.getParameter("publishdate");
			
			Book book = new Book();
			book.setId(id);
			book.setTitle(title);
			book.setAuthor(author);
			book.setPublishDate(publishdate);
			
			int status = BookService.getInstance().updateBook(book);
			if(status > 0){
				logging.info("update Successfully");
				response.sendRedirect("ServletController?action="+Utils.ACTION_VIEW);
			}else {
				String message = "update failed!";
				request.setAttribute("message", message);
				RequestDispatcher rd = request.getRequestDispatcher("/update.jsp");
				rd.forward(request, response);
			}
		}
		if(Utils.ACTION_DELETE.equals(action)){
			int id = Integer.parseInt(request.getParameter("id"));
			int status = BookService.getInstance().deleteBook(id);
			
			if(status > 0){
				logging.info("delete Successfully");
				response.sendRedirect("ServletController?action="+Utils.ACTION_VIEW);
			}
		}
		if(Utils.ACTION_VIEW.equals(action)){
			logging.info("There is a User access into listBook!");
			List<Book> listbook = BookService.getInstance().getAllBook();
			request.setAttribute("listbook", listbook);
			RequestDispatcher rd = request.getRequestDispatcher("/listBook.jsp");
			rd.forward(request, response);
		}
	}

}
