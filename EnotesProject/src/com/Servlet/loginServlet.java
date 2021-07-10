package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.User.UserDetails;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("uemail");
		String password = request.getParameter("upassword");
		
		UserDetails userdetails = new UserDetails();
		userdetails.setEmail(email);
		userdetails.setPassword(password);
		
		UserDAO userdao =new UserDAO(DBConnect.getConn());
		UserDetails user = userdao.loginUser(userdetails);
		
		if(user != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("userD", user);
			response.sendRedirect("home.jsp");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("login-failed", "Invalid Username and Password");
			response.sendRedirect("login.jsp");
			
		}
	}

}
