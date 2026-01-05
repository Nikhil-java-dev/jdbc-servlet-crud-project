package com.hcl.jdbc_and_servlet_crud_project.controller;

import com.hcl.jdbc_and_servlet_crud_project.dao.ProductDao;

public class DeleteProductByIdController {
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		boolean b = dao.deleteProductByIdDao(6);
		String msg = b  ? "Product is Deleted From DataBase" : "Invalid! Something went wrong";
		System.out.println(msg);
	}
}
