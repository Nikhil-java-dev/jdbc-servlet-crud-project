<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/nav.css">
<style>

@charset "UTF-8";

/* =========================
   NAVBAR CONTAINER
========================= */
nav.navbar1 {
    height: 70px;
    width: 100%;
    background: linear-gradient(90deg, #0f0c29, #302b63, #24243e);
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 40px;
    position: sticky;
    top: 0;
    z-index: 1000;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.6);
    font-family: 'Segoe UI', Tahoma, sans-serif;
}

/* =========================
   LOGO
========================= */
nav.navbar1 .logo {
    font-size: 22px;
    font-weight: bold;
    color: #f9d342;
    display: flex;
    align-items: center;
    gap: 8px;
    cursor: pointer;
}

nav.navbar1 .logo i {
    transition: transform 0.3s ease;
}

nav.navbar1 .logo:hover i {
    transform: rotate(20deg);
    color: #ff6f61;
}

/* =========================
   NAV LINKS
========================= */
nav.navbar1 ul.nav-links {
    list-style: none;
    display: flex;
    gap: 25px;
    margin: 0;
    padding: 0;
}

/* FORCE OVERRIDE BOOTSTRAP */
nav.navbar1 ul.nav-links > li > a {
    color: #f9d342 !important;
    text-decoration: none !important;
    font-size: 18px;
    padding: 10px 18px;
    display: flex;
    align-items: center;
    gap: 6px;
    border-radius: 8px;
    transition: all 0.3s ease;
}

/* Icon color */
nav.navbar1 ul.nav-links > li > a i {
    color: #f9d342 !important;
}

/* Hover effect */
nav.navbar1 ul.nav-links > li > a:hover {
    background-color: rgba(255, 111, 97, 0.85) !important;
    color: #ffffff !important;
    transform: scale(1.08);
    box-shadow: 0 4px 15px rgba(255, 111, 97, 0.6);
}

/* =========================
   HAMBURGER MENU
========================= */
nav.navbar1 .hamburger {
    display: none;
    flex-direction: column;
    cursor: pointer;
    gap: 5px;
}

nav.navbar1 .hamburger span {
    width: 25px;
    height: 3px;
    background-color: #f9d342;
    border-radius: 3px;
    transition: all 0.3s ease;
}

/* Hamburger animation */
nav.navbar1 .hamburger.active span:nth-child(1) {
    transform: rotate(45deg) translate(5px, 5px);
}

nav.navbar1 .hamburger.active span:nth-child(2) {
    opacity: 0;
}

nav.navbar1 .hamburger.active span:nth-child(3) {
    transform: rotate(-45deg) translate(6px, -6px);
}

/* =========================
   RESPONSIVE (MOBILE)
========================= */
@media (max-width: 768px) {
    nav.navbar1 {
        flex-wrap: wrap;
        height: auto;
        padding: 15px 20px;
    }

    nav.navbar1 .hamburger {
        display: flex;
    }

    nav.navbar1 ul.nav-links {
        flex-direction: column;
        width: 100%;
        display: none;
        margin-top: 15px;
        background-color: rgba(0, 0, 0, 0.9);
        border-radius: 10px;
        padding: 10px 0;
    }

    nav.navbar1 ul.nav-links.open {
        display: flex;
    }

    nav.navbar1 ul.nav-links li {
        text-align: center;
    }

    nav.navbar1 ul.nav-links > li > a {
        justify-content: center;
        padding: 12px 0;
        width: 100%;
    }
}



</style>
</head>
<body>
  
<%--navbar starts --%>
<%-- 
<nav class="navbar1">
<div class="logo"><i class="fa-brands fa-product-hunt"></i> ProductManager</div>
		<ul class="nav-links">
			<li><a href="index.jsp"><i class="fa-solid fa-house"></i> Home</a></li>
			<li><a href="user-register.jsp"><i class="fa-solid fa-user-plus"></i> Register</a></li>
			<li><a href="user-login.jsp"><i class="fa-solid fa-arrow-right-to-bracket"></i> Login</a></li>
			<li><a href="logout"><i class="fa-solid fa-right-from-bracket"></i> Logout</a></li>
		</ul>
	</nav>
	
	--%>
	

<%--navbar ends --%>




<nav class="navbar1">
    <div class="logo">
        <i class="fa-brands fa-product-hunt"></i> ProductManager
    </div>

    <!-- Hamburger menu for mobile -->
    <div class="hamburger" id="hamburger">
        <span></span>
        <span></span>
        <span></span>
    </div>

    <ul class="nav-links" id="nav-links">
        <li><a href="index.jsp"><i class="fa-solid fa-house"></i> Home</a></li>
        <li><a href="user-register.jsp"><i class="fa-solid fa-user-plus"></i> Register</a></li>
        <li><a href="user-login.jsp"><i class="fa-solid fa-arrow-right-to-bracket"></i> Login</a></li>
        <li><a href="logout"><i class="fa-solid fa-right-from-bracket"></i> Logout</a></li>
    </ul>
</nav>

<script>
    const hamburger = document.getElementById('hamburger');
    const navLinks = document.getElementById('nav-links');

    hamburger.addEventListener('click', () => {
        navLinks.classList.toggle('open');
        hamburger.classList.toggle('active');
    });
</script>








</body>
</html>