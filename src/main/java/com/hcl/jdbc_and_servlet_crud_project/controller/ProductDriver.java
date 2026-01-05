package com.hcl.jdbc_and_servlet_crud_project.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hcl.jdbc_and_servlet_crud_project.dao.ProductDao;
import com.hcl.jdbc_and_servlet_crud_project.dto.Product;

public class ProductDriver {
	public static void main(String[] args) {
		ProductDao dao = new ProductDao();
		List<Product> l1 = new ArrayList<>();

		Product p1 = new Product();
		p1.setId(7);
		p1.setName("Mango Picklel");
		p1.setColor("yellow");
		p1.setPrice(1500.0);
		p1.setMfd(LocalDate.parse("2025-02-12"));
		p1.setExpd(LocalDate.parse("2026-03-03"));
		l1.add(p1);

		Product p2 = new Product();
		p2.setId(8);
		p2.setName("Electronics");
		p2.setColor("various");
		p2.setPrice(1500.0);
		p2.setMfd(LocalDate.parse("2025-02-12"));
		p2.setExpd(LocalDate.parse("2026-03-03"));
		l1.add(p2);

		Product p3 = new Product();
		p3.setId(9);
		p3.setName("Refrigerator");
		p3.setColor("Red");
		p3.setPrice(150000.0);
		p3.setMfd(LocalDate.parse("2025-02-12"));
		p3.setExpd(LocalDate.parse("2045-03-03"));
		l1.add(p3);

		Product p4 = new Product();
		p4.setId(10);
		p4.setName("Soya chunkes");
		p4.setColor("transparent");
		p4.setPrice(150000.0);
		p4.setMfd(LocalDate.parse("2025-02-12"));
		p4.setExpd(LocalDate.parse("2045-03-03"));
		l1.add(p4);

		Product p5 = new Product();
		p5.setId(11);
		p5.setName("Butter");
		p5.setColor("yellow");
		p5.setPrice(150000.0);
		p5.setMfd(LocalDate.parse("2025-02-12"));
		p5.setExpd(LocalDate.parse("2045-03-03"));
		l1.add(p5);

		List<Product> p = dao.saveAllProductFromCollection(l1);

		System.out.println(l1);

		String msg = p != null ? "Data Inserted" : "Invalid! Something went wrong";
		System.out.println(msg);

	}
}
