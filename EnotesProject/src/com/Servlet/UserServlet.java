package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.Db.DBConnect;
import com.User.UserDetails;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("fname");
		String email = request.getParameter("uemail");
		String password = request.getParameter("upassword");
		
		UserDetails userdetails = new UserDetails();
		userdetails.setName(name);
		userdetails.setEmail(email);
		userdetails.setPassword(password);
		
		
	
			UserDAO userdao = new UserDAO(DBConnect.getConn());
			boolean f=false;
			HttpSession session;
			
			try {
			f = userdao.addUser(userdetails);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(f) {
			session = request.getSession();
			session.setAttribute("reg-success", "Registration Successfully.");
			response.sendRedirect("register.jsp");
			}
			else {
				session = request.getSession();
				session.setAttribute("failed-msg", "Something went wrong on server");
				response.sendRedirect("register.jsp");
			}
		
			
			 
						
				
			
			
		
		
		
		
	}
	

}
