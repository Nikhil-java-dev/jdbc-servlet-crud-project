<%@page import="com.hcl.jdbc_and_servlet_crud_project.dto.Product"%>
<%@page import="com.hcl.jdbc_and_servlet_crud_project.dao.ProductDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display All Product</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<link rel ="stylesheet" href="./css/display-product.css">

</head>
<body>
<jsp:include page="navbar.jsp" />
	<main>
		<h1 class="title">ALL PRODUCT DETAILS</h1>


		<%
		List<Product> products = new ProductDao().getAllProductDetailsDao();
		%>
		<div class="container">
		<table class="product-table">

		
			<tr style="color: black;">
				<th><i class="fa-regular fa-id-badge"></i>Id</th>
				<th>Name</th>
				<th>Color</th>
				<th><i class="fa-solid fa-indian-rupee-sign"></i>Price</th>
				<th>Mfd</th>
				<th>Expd</th>
				<th colspan="2">Action</th>
			</tr>

			<%
			double totalPrice = 0;
			for (Product product : products) {
				totalPrice += product.getPrice();
			%>
			<tr>
				<td><%=product.getId()%></td>
				<td><%=product.getName()%></td>
				<td><%=product.getColor()%></td>
				<td><%=product.getPrice()%></td>
				<td><%=product.getMfd()%></td>
				<td><%=product.getExpd()%></td>
				<td class="action-btn"><a class="action-btn edit-btn"
					href="productUpdate?id=<%=product.getId()%>" class="edit"><i
						class="fa-solid fa-pen-to-square"></i>Edit</a> <a class="action-btn delete-btn"
					href="delete-product?id=<%=product.getId()%>" class="delete"><i
						class="fa-solid fa-trash-can"></i>Delete</a></td>
			</tr>


			<%
			}
			%>
			<!-- Display total product count and total price -->
			<tr>
				<td colspan="2" style="font-weight: bold; color: red;">Total
					Product</td>
				<td colspan="5" style="font-weight: bold;"><%=products.size()%></td>
			</tr>
			<tr>
				<td colspan="2" style="font-weight: bold; color: red;">Total
					Price</td>
				<td colspan="5" style="font-weight: bold;"><%=totalPrice%></td>
			</tr>
			
		</table>
		</div>
		<br>
		<div class="div">
		<a href="product-register.jsp"><input type="button" value="Click here to Register NewProduct" class="add-btn"></a>
		</div>
	</main>
	<%--footer --%>
	<jsp:include page="footer.jsp"/>
	
	<%--footer --%>
</body>
</html>