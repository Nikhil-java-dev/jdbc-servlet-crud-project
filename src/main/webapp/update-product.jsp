<%@page import="jakarta.servlet.http.HttpSession"%>
<%@page import="com.hcl.jdbc_and_servlet_crud_project.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product</title>

<style>
body {
	margin: 0;
	min-height: 100vh;
	background: linear-gradient(135deg, #667eea, #764ba2);
	display: flex;
	justify-content: center;
	align-items: center;
	font-family: "Segoe UI", sans-serif;
}

section {
	width: 480px;
	background: rgba(255, 255, 255, 0.15);
	backdrop-filter: blur(15px);
	padding: 35px;
	border-radius: 15px;
	box-shadow: 0 25px 40px rgba(0, 0, 0, 0.25);
}

h1 {
	text-align: center;
	color: white;
	margin-bottom: 25px;
}

label {
	font-weight: 600;
	color: #fff;
}

input {
	width: 100%;
	padding: 10px;
	margin-top: 6px;
	margin-bottom: 18px;
	border-radius: 6px;
	border: none;
	outline: none;
}

input:focus {
	box-shadow: 0 0 5px #fff;
}

.submit-btn {
	width: 100%;
	padding: 12px;
	border: none;
	border-radius: 8px;
	background: linear-gradient(to right, #1d4ed8, #2563eb);
	color: white;
	font-size: 16px;
	cursor: pointer;
	transition: 0.5s;
	margin-left: 10px;
	display: block;
}

.submit-btn:hover {
	background: linear-gradient(to right, #1e3a8a, #1d4ed8);
}

.submit-btn:active {
	transform: scale(0.98);
}
</style>
</head>

<body>
	<section>
		<%-- 
		<%
    
    HttpSession httpSession=request.getSession();
	
	String userEmail=(String)httpSession.getAttribute("userSession");
	
	if(userEmail!=null){
    
//    int id = Integer.parseInt(request.getParameter("id"));
//    Product p = new ProductDao().getProductByIdDao(id);
	  Product p = (Product)request.getAttribute("product");
	%>
	--%>

		<%
		HttpSession httpSession = request.getSession(false);
		if (httpSession == null || httpSession.getAttribute("userSession") == null) {
			response.sendRedirect("user-login.jsp");
			return;
		}

		Product p = (Product) request.getAttribute("product");
		if (p == null) {
			response.sendRedirect("display-product.jsp");
			return;
		}
		%>





		<h1>Update Product</h1>
		<form action="productUpdate" method="post">

			<label>Product ID</label> <input type="text" name="id"
				value="<%=p.getId()%>" readonly> <label>Product Name</label>
			<input type="text" name="name" value="<%=p.getName()%>"> <label>Product
				Color</label> <input type="text" name="color" value="<%=p.getColor()%>">

			<label>Product Price</label> <input type="text" name="price"
				value="<%=p.getPrice()%>"> <label>Manufacture Date</label> <input
				type="date" name="mfd" value="<%=p.getMfd()%>"> <label>Expiry
				Date</label> <input type="date" name="expd" value="<%=p.getExpd()%>">

			<input type="submit" value="Update" class="submit-btn">
		</form>

		<%-- 
		<% } else{ %>
		<%
			response.sendRedirect("user-login.jsp");
		%>
		<%} %>
		
		--%>
	</section>
</body>
</html>
