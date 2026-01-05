package com.hcl.jdbc_and_servlet_crud_project.ui.controller;

import java.io.IOException;

import com.hcl.jdbc_and_servlet_crud_project.dao.UserDao;
import com.hcl.jdbc_and_servlet_crud_project.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(value = "/userLogin")
public class UserLoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao userDao = new UserDao();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println("email=" + email);
		User user = userDao.loginUser(email);
		
		 if (user != null && password.equals(user.getPassword())) {

	            HttpSession session = req.getSession(true);
	            session.setAttribute("userSession", user.getEmail());
	            session.setMaxInactiveInterval(30); // 30 

	            resp.sendRedirect("display-product.jsp");

	        } else {
	            HttpSession session = req.getSession(true);
	            session.setAttribute("msg", "Invalid email or password");
	            resp.sendRedirect("user-login.jsp");
	        }
	    }
	}
		
//      HttpSession httpSession = req.getSession();
//		if(user!=null) {
//			
//			if(password.equals(user.getPassword())) {
//				httpSession.setAttribute("userSession", user.getEmail());
//				httpSession.setMaxInactiveInterval(30);
//				
//				
//				resp.sendRedirect("display-product.jsp");
//				
//			}else {
//				System.out.println("Invalid password! Please try again.");
////				req.setAttribute("msg", "Invalid password! Please try again.");
////				req.getRequestDispatcher("user-login.jsp").forward(req, resp);
//				httpSession.setAttribute("msg", "Invalid password! Please try again.");
//				resp.sendRedirect("user-login.jsp");
//			}
//			
//		}else {
//			System.out.println("Invalid email! Please try again.");
////			req.setAttribute("msg", "Invalid email! Please try again.");
////			req.getRequestDispatcher("user-login.jsp").forward(req, resp);
//			httpSession.setAttribute("msg", "Invalid email! Please try again.");
//			resp.sendRedirect("user-login.jsp");
//		}
//	}
//}
