package com.hcl.jdbc_and_servlet_crud_project.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

/**
 * 
 * 
		        ┌───────────────────────────────┐
		        │     new Driver() is created   │
		        └───────────────┬───────────────┘
		                        │
		                        │ registerDriver()
		                        ▼
		        ┌───────────────────────────────┐
		        │    DriverManager Registry     │
		        │ (Knows which driver to use)   │
		        └───────────────┬───────────────┘
		                        │
		                        │ getConnection(url, user, pass)
		                        ▼
		       ┌───────────────────────────────────┐
		       │         MYSQL DATABASE SERVER     │
		       │   (localhost:3306 / jdbc-m16 DB)  │
		       └────────────────┬──────────────────┘
		                        │
		                        │  Connection Established
		                        ▼
		       ┌─────────────────────────────────────┐
		       │       Connection Object (Java)      │
		       │     - Used for SQL operations       │
		       └─────────────────────────────────────┘

 * 
 * 
 */

public class JdbcConnection {
	public static Connection getJdbcConnection() {

		try {

			Driver driver = new Driver();

			DriverManager.registerDriver(driver);

			String url = "jdbc:mysql://localhost:3306/jdbc-m16";
			String username = "root";
			String password = "root";

			Connection connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
}
