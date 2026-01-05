package com.hcl.jdbc_and_servlet_crud_project.ui.controller;

import java.io.IOException;
import com.hcl.jdbc_and_servlet_crud_project.dao.ProductDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(value="/delete-product")
public class DeleteProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ProductDao productDAO = new ProductDao();
		int id = Integer.parseInt(req.getParameter("id"));
		boolean b = productDAO.deleteProductByIdDao(id);
		if(b) {
			RequestDispatcher dis = req.getRequestDispatcher("display-product.jsp");
			dis.include(req, resp);
		}
		System.out.println("..................Delete Product Details...................");
		System.out.println("id = " + id);
	}
}
