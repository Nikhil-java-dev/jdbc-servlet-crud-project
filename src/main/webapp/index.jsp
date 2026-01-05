

<%@page import="com.hcl.jdbc_and_servlet_crud_project.dao.ProductDao"%>
<%@page import="com.hcl.jdbc_and_servlet_crud_project.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
  .hero {
    height: 80vh;
    background: linear-gradient(to right, #007bff, #00c6ff);
    color: white;
    display: flex;
    align-items: center;
  }
</style>
</head>

<body>

<!-- Navbar -->
	
	<jsp:include page="navbar.jsp" />
		<!-- Hero Section -->
		<div class="hero">
			<div class="container text-center">
				<h1 class="display-4 fw-bold"><i class="fa-brands fa-product-hunt"></i> Product Management System</h1>
				<p class="lead">Manage your products easily and efficiently</p>

				<a href="product-register.jsp" class="btn btn-light btn-lg me-2">Add
					Product</a> <a href="display-product.jsp"
					class="btn btn-outline-light btn-lg">View Products</a>
			</div>
		</div>

		<!-- Features -->
		<div class="container mt-5">
			<div class="row text-center">
				<div class="col-md-4">
					<h4>📦 Add Products</h4>
					<p>Add new products with details.</p>
				</div>
				<div class="col-md-4">
					<h4>✏ Edit Products</h4>
					<p>Update product information easily.</p>
				</div>
				<div class="col-md-4">
					<h4>🗑 Delete Products</h4>
					<p>Remove outdated products safely.</p>
				</div>
			</div>
		</div>

		<!-- Footer -->
		<jsp:include page="footer.jsp"/>
</body>
</html>