package com.hcl.jdbc_and_servlet_crud_project.ui.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.hcl.jdbc_and_servlet_crud_project.dao.ProductDao;
import com.hcl.jdbc_and_servlet_crud_project.dto.Product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RegisterProductController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ProductDao dao = new ProductDao();

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String color = req.getParameter("color");
		double price = Double.parseDouble(req.getParameter("price"));
		LocalDate mfd = LocalDate.parse(req.getParameter("mfd"));
		LocalDate expd = LocalDate.parse(req.getParameter("expd"));
		System.out.println("..................Product Details...................");

		Product product = new Product();

		product.setId(id);
		product.setName(name);
		product.setColor(color);
		product.setPrice(price);
		product.setMfd(mfd);
		product.setExpd(expd);

		Product product2 = dao.saveProductDao(product);

		//PrintWriter printWriter = resp.getWriter();

		if (product2 != null) {
			resp.getWriter().print(
					"<html><body><h2 style='color:green; text-align: center;'>------------Product Registered Successfully------------</h2></body></html>");
			
			req.getRequestDispatcher("display-product.jsp").include(req, resp);
			
			
			System.out.println("------------Product Registered Successfully------------");
		} else {
			req.getRequestDispatcher("product-register.jsp").include(req, resp);
			resp.getWriter().print(
					"<html><body><h2 style='color:red';>------------Product Not Registered Successfully------------</h2></body></html>");
		}
	}
}
