# JDBC Servlet CRUD Project

## Description
This is a Java-based web application developed using JDBC and Servlets.  
The project demonstrates CRUD (Create, Read, Update, Delete) operations for managing users and products with a MySQL database.

It is designed to showcase core backend development concepts and is suitable for learning and interview preparation.

---

## Features
- User Management (Add, View, Update, Delete)
- Product Management (Add, View, Update, Delete)
- Sorting data using Comparator and Java Streams
- JDBC Batch Processing
- Stored Procedures in MySQL
- Session management using HttpSession
- MVC architecture (Controller, DAO, DTO)

---

## Technologies Used
- Java
- JDBC
- Servlet & JSP
- MySQL
- Maven
- Apache Tomcat
- HTML, CSS, js

---

## Project Structure
jdbc-and-servlet-crud-project
│
├── pom.xml
├── .classpath
├── .project
├── .mvn/
│   ├── jvm.config
│   └── maven.config
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── hcl/
│       │           └── jdbc_and_servlet_crud_project/
│       │               ├── connection/
│       │               │   └── JdbcConnection.java
│       │               │
│       │               ├── controller/
│       │               │   ├── ProductController.java
│       │               │   ├── UserLoginController.java
│       │               │   └── UserRegisterController.java
│       │               │
│       │               ├── dao/
│       │               │   ├── ProductDao.java
│       │               │   └── UserDao.java
│       │               │
│       │               ├── dto/
│       │               │   ├── Product.java
│       │               │   └── User.java
│       │               │
│       │               ├── exception/
│       │               ├── services/
│       │               └── ui/
│       │                   └── ProductDriver.java
│       │
│       ├── resources/
│       │
│       └── webapp/
│           ├── css/
│           │   └── nav.css
│           │
│           ├── image/
│           │   ├── b.png
│           │   ├── bb.png
│           │   ├── bbb.png
│           │   └── bkg.png
│           │
│           ├── add-product.jsp
│           ├── update-product.jsp
│           ├── user-login.jsp
│           ├── user-register.jsp
│           │
│           └── WEB-INF/
│               └── web.xml
│
└── README.md
