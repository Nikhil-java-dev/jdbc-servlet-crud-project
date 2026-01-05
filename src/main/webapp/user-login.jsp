<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<link rel="stylesheet" href="./css/login.css">


</head>

<body>

	<div class="container">
		<h1>
			<i class="fa-solid fa-arrow-right-to-bracket"></i> Login Page
		</h1>
		<%
	    		String msg = (String)session.getAttribute("msg");
	    		if(msg != null){
	    %>
		<h3 style="color: crimson; text-align: center; margin-bottom: 15px;"><%= msg %></h3>
		<%
	    		session.removeAttribute("msg");
	    		}
	    	%>

		<form action="userLogin" method="post">

			<label>UserEmail</label>
			<div class="input-box">
				<input type="email" name="email" placeholder="Enter email" required>

				<i class="fa-solid fa-user"></i>
			</div>

			<label>User Password</label>
			<div class="input-box">
				<input type="password" name="password" placeholder="Enter password"
					required> <i class="fa-solid fa-lock"></i>
			</div>


			<button type="submit" value="Login">Login</button>
		</form>
		<div class="footer-text">
			<a href="user-register.jsp">Don't have an account?Register</a>
		</div>
	</div>
</body>
</html>