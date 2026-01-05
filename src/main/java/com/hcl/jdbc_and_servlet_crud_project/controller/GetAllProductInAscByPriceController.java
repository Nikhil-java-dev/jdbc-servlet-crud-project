package com.hcl.jdbc_and_servlet_crud_project.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.hcl.jdbc_and_servlet_crud_project.dao.ProductDao;
import com.hcl.jdbc_and_servlet_crud_project.dto.Product;

public class GetAllProductInAscByPriceController {
	public static void main(String[] args) {
		List<Product> products = new ProductDao().getAllProductDetailsDao();
		List<Product> products2 = products.stream().sorted(Comparator.comparing(Product :: getPrice)).collect(Collectors.toList());
		products2.forEach(System.out::println);
		
	}
}
