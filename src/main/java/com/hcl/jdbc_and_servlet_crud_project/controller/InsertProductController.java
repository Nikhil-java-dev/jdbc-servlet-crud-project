package com.hcl.jdbc_and_servlet_crud_project.controller;

import java.time.LocalDate;

import com.hcl.jdbc_and_servlet_crud_project.dao.ProductDao;
import com.hcl.jdbc_and_servlet_crud_project.dto.Product;

public class InsertProductController {
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		
		Product product = new Product();
		
		product.setId(658);
		product.setName("pen");
		product.setColor("blue");
		product.setPrice(30);
		product.setMfd(LocalDate.parse("2025-12-01"));
		product.setExpd(LocalDate.parse("2025-12-31"));
		
		Product p = dao.saveProductDao(product);
		
		String msg = p != null ? "Product saved into database" : "Something went wrong";
		System.out.println(msg);
	}
}

