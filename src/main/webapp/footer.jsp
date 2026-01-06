<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Footer</title>
<link rel="stylesheet" href="./css/nav.css">
<style>

/* =========================
   FOOTER
========================= */
.site-footer {
    background: linear-gradient(90deg, #0f0c29, #302b63, #24243e);
    color: #eaeaea;
    padding: 40px 20px 15px;
    font-family: 'Segoe UI', Tahoma, sans-serif;
}

.footer-container {
    max-width: 1200px;
    margin: auto;
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    gap: 30px;
}

/* Footer sections */
.footer-section h2,
.footer-section h3 {
    color: #f9d342;
    margin-bottom: 12px;
}

.footer-section p {
    font-size: 15px;
    line-height: 1.6;
    color: #dcdcdc;
}

/* Links */
.footer-section ul {
    list-style: none;
    padding: 0;
}

.footer-section ul li {
    margin-bottom: 8px;
}

.footer-section ul li a {
    color: #dcdcdc;
    text-decoration: none;
    transition: 0.3s;
}

.footer-section ul li a:hover {
    color: #ff6f61;
    padding-left: 5px;
}

/* Social icons */
.social-icons {
    display: flex;
    gap: 15px;
    margin-top: 10px;
}

.social-icons a {
    color: #f9d342;
    font-size: 20px;
    transition: 0.3s;
}

.social-icons a:hover {
    color: #ff6f61;
    transform: scale(1.2);
}

/* Bottom bar */
.footer-bottom {
    margin-top: 30px;
    border-top: 1px solid rgba(255,255,255,0.2);
    padding-top: 12px;
    text-align: center;
    font-size: 14px;
    color: #cccccc;
}

/* =========================
   RESPONSIVE
========================= */
@media (max-width: 900px) {
    .footer-container {
        grid-template-columns: repeat(2, 1fr);
    }
}

@media (max-width: 600px) {
    .footer-container {
        grid-template-columns: 1fr;
        text-align: center;
    }

    .social-icons {
        justify-content: center;
    }
}

</style>
</head>
<body>
<%-- 
<footer class="footer">
  <a href="https://www.linkedin.com/in/nikhil-srivastava-7a2266298?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app" class="footer-anc">© 2025 Product Management System | LinkedIn</a>
</footer>
	
	--%>
	
	
	<footer class="site-footer">
    <div class="footer-container">

        <!-- Brand -->
        <div class="footer-section brand">
            <h2><i class="fa-brands fa-product-hunt"></i> ProductManager</h2>
            <p>Simple & secure product management system built using JDBC, Servlets & JSP.</p>
        </div>

        <!-- Quick Links -->
        <div class="footer-section links">
            <h3>Quick Links</h3>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="user-register.jsp">Register</a></li>
                <li><a href="user-login.jsp">Login</a></li>
                <li><a href="logout">Logout</a></li>
            </ul>
        </div>

        <!-- Tech Stack -->
        <div class="footer-section tech">
            <h3>Tech Stack</h3>
            <p>Java • JDBC • Servlets • JSP • MySQL</p>
        </div>

        <!-- Social -->
        <div class="footer-section social">
            <h3>Connect</h3>
            <div class="social-icons">
                <a href="https://linkedin.com/in/nikhil-srivastava-7a2266298" class="footer-anc"><i class="fa-brands fa-linkedin"></i></a>
                <a href="https://github.com/Nikhil-java-dev"><i class="fa-brands fa-github"></i></a>
                <a href="http://gmail.com/"><i class="fa-solid fa-envelope"></i></a>
            </div>
        </div>

    </div>

    <div class="footer-bottom">
        © 2026 ProductManager | Developed by Nikhil
    </div>
</footer>
	
	
</body>
</html>
