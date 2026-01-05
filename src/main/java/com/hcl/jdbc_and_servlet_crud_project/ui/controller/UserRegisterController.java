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


@SuppressWarnings({ "serial"})
@WebServlet(value="/userRegistration")
public class UserRegisterController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("..................User Registration Details...................");
		//read form data
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		//create user object store form data
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		//call userDao
		UserDao userDao = new UserDao();
		boolean b = userDao.registerUser(user);
		
		//session for message
		HttpSession session = req.getSession();
		if (b) {
			System.out.println("------------User Registered Successfully------------");
			session.setAttribute("user", "User Registered Successfully with email: " + user.getEmail());
			resp.sendRedirect("user-login.jsp");
			
		} else {
			System.out.println("------------User Registration Failed------------");
			session.setAttribute("user-err", "User Registration Failed for email: " + user.getEmail());
			resp.sendRedirect("user-register.jsp");
		}
		
		
	}

}
