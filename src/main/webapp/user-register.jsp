<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Registration</title>

<link rel ="stylesheet" href="./css/user-register.css">
</head>

<body>

	<div class="container">
		<h2>📦 User Registration</h2>

		<form action="userRegistration" method="post">

	<label>UserEmail</label> <input type="email" name="email"
				placeholder="Enter userName" required> <label>User
				Password</label> <input type="password" name="password"
				placeholder="Enter password" required>


			<button type="submit" value="registerUser">Register User</button>
		</form>

		<div class="footer-text">© 2025 Product Management System</div>
	</div>
</body>
</html>