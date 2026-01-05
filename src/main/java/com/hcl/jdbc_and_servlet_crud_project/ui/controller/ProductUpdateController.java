package com.hcl.jdbc_and_servlet_crud_project.ui.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.hcl.jdbc_and_servlet_crud_project.dao.ProductDao;
import com.hcl.jdbc_and_servlet_crud_project.dto.Product;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/productUpdate")
public class ProductUpdateController extends HttpServlet {

    // -------------------- LOAD UPDATE PAGE --------------------
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Session validation
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userSession") == null) {
        	
	        	HttpSession newSession = req.getSession(true);
	        newSession.setAttribute("msg", "Session expired. Please login again.");

            resp.sendRedirect("user-login.jsp");
            return;
        }

        try {
            int id = Integer.parseInt(req.getParameter("id"));

            ProductDao dao = new ProductDao();
            Product product = dao.getProductByIdDao(id);

            if (product == null) {
                req.setAttribute("msg", "Product not found");
                req.getRequestDispatcher("display-product.jsp").forward(req, resp);
                return;
            }

            req.setAttribute("product", product);
            RequestDispatcher dispatcher = req.getRequestDispatcher("update-product.jsp");
            dispatcher.forward(req, resp);

        } catch (NumberFormatException e) {
            req.setAttribute("msg", "Invalid product id");
            req.getRequestDispatcher("display-product.jsp").forward(req, resp);
        }
    }

    // -------------------- UPDATE PRODUCT --------------------
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Session validation
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("userSession") == null) {
        	
	        	HttpSession newSession = req.getSession(true);
	        newSession.setAttribute("msg", "Session expired. Please login again.");

            resp.sendRedirect("user-login.jsp");
            return;
        }

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String color = req.getParameter("color");
            double price = Double.parseDouble(req.getParameter("price"));
            LocalDate mfd = LocalDate.parse(req.getParameter("mfd"));
            LocalDate expd = LocalDate.parse(req.getParameter("expd"));

            Product product = new Product();
            product.setId(id);
            product.setName(name);
            product.setColor(color);
            product.setPrice(price);
            product.setMfd(mfd);
            product.setExpd(expd);

            ProductDao dao = new ProductDao();
            boolean status = dao.updateProductDetails(product);

            if (status) {
                resp.sendRedirect("display-product.jsp");
            } else {
                req.setAttribute("msg", "Product update failed");
                req.getRequestDispatcher("update-product.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            req.setAttribute("msg", "Invalid input data");
            req.getRequestDispatcher("update-product.jsp").forward(req, resp);
        }
    }
}
