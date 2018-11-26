package web31.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web31.common.Utils;


public class LoginLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginLogout() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handLog(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		handLog(request, response);
	}


	private void handLog(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String action = request.getParameter(Utils.ACTION);
		
		if(Utils.ACTION_LOGIN.equals(action)){
			String userName = request.getParameter("userName");
			String passWord = request.getParameter("passWord");
			
			if(userName.equals("admin") && passWord.equals("admin")){
				HttpSession session = request.getSession();
				session.setAttribute("userName", userName);
				session.setMaxInactiveInterval(60);
				
				RequestDispatcher rd = request.getRequestDispatcher("/trangchu.jsp");
				rd.forward(request, response);
			}else{
				String message = "login failed";
				request.setAttribute("message", message);
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			}
		}
		if(Utils.ACTION_LOGOUT.equals(action)){
			HttpSession session = request.getSession();
			session.invalidate();
			
			String message = "Logout Successfully!";
			response.sendRedirect("login.jsp?message=" + message);
		}
	}
}
