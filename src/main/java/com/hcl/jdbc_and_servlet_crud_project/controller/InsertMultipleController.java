package com.hcl.jdbc_and_servlet_crud_project.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hcl.jdbc_and_servlet_crud_project.dao.ProductDao;
import com.hcl.jdbc_and_servlet_crud_project.dto.Product;

public class InsertMultipleController {
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();

		Product p1 = new Product();
		p1.setId(7);
		p1.setColor("yellow");
		p1.setName("Mango Picklel");
		p1.setPrice(1500.0);
		p1.setMfd(LocalDate.parse("2025-02-12"));
		p1.setExpd(LocalDate.parse("2026-03-03"));

		Product p2 = new Product();
		p2.setId(8);
		p2.setName("Electronics");
		p2.setColor("various");
		p2.setPrice(1500.0);
		p2.setMfd(LocalDate.parse("2025-02-12"));
		p2.setExpd(LocalDate.parse("2026-03-03"));

		Product p3 = new Product();
		p3.setId(9);
		p3.setName("Refrigerator");
		p3.setColor("Red");
		p3.setPrice(150000.0);
		p3.setMfd(LocalDate.parse("2025-02-12"));
		p3.setExpd(LocalDate.parse("2045-03-03"));

		List<Product> products = new ArrayList<>(Arrays.asList(p1, p2, p3));// we can also use new List.of(p1, p2, p3);

		dao.savaMultipleProductDao(products);
	}
}
