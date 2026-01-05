    package com.hcl.jdbc_and_servlet_crud_project.controller;

import com.hcl.jdbc_and_servlet_crud_project.dao.ProductDao;
import com.hcl.jdbc_and_servlet_crud_project.dto.Product;

public class DisplayProductByIdController {
	public static void main(String[] args) {
	ProductDao dao = new ProductDao();
	Product p = dao.getProductByIdDao(7);
	
	if(p != null) {
		//optional class in java
		System.out.println(p);
	} else {
		System.out.println("-------------check Your Code  given id is not found or Something went wrong!-------------");
	}
	}
}
