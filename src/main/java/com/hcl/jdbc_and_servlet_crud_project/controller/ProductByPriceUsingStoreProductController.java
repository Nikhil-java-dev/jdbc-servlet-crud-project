package com.hcl.jdbc_and_servlet_crud_project.controller;

import java.util.List;

import com.hcl.jdbc_and_servlet_crud_project.dao.ProductDao;
import com.hcl.jdbc_and_servlet_crud_project.dto.Product;

public class ProductByPriceUsingStoreProductController {
	public static void main(String[] args) {
		List<Product> products = new ProductDao().getProductByPriceDao(1500);
		if(!products.isEmpty()) {
			//products.forEach(pro -> System.out.println(pro));
//			for(Product p : products)
//				System.out.println(p);
			products.forEach(System.out::println);
		}
	}
}
