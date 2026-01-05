package com.hcl.jdbc_and_servlet_crud_project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hcl.jdbc_and_servlet_crud_project.dto.Product;
import com.hcl.jdbc_and_servlet_crud_project.connection.JdbcConnection;

       
public class ProductDao {
	/**
	 * save ProductDao(Product product)
	 * 
	 * @return Product;
	 * 
					   ┌───────────────────────────┐
					   │     Your Java Program     │
					   └──────────────┬────────────┘
					                  │
					                  │ 1. You create an empty Product object
					                  ▼
					        ┌────────────────────────┐
					        │     Product Object     │
					        │    (empty at start)    │
					        └───────────┬────────────┘
					                    │
					                    │ 2. You fill data using SETTERS
					                    ▼
					        ┌────────────────────────┐
					        │     Product Object     │
					        │  id = 101              │
					        │  name = "Pen"          │
					        │  price = 20            │
					        └───────────┬────────────┘
					                    │
					                    │ 3. Now you want to INSERT into DB
					                    │
					                    │  Database needs RAW VALUES
					                    ▼
					   ┌─────────────────────────────────┐
					   │ PreparedStatement (INSERT ?)    │
					   └───────────────┬─────────────────┘
					                   │
					                   │ 4. To give raw values,
					                   │    you must take them OUT
					                   │    from Product object
					                   │    → using GETTERS
					                   ▼
					   ┌─────────────────────────────────┐
					   │  ps.setInt(1,  p.getId());      │  ← VALUE TAKEN OUT
					   │  ps.setString(2, p.getName());  │  ← VALUE TAKEN OUT
					   │  ps.setDouble(3, p.getPrice()); │  ← VALUE TAKEN OUT
					   └─────────────────────────────────┘
					                   │
					                   │ 5. Now PreparedStatement
					                   │    has the values, so INSERT works
					                   ▼
					       ┌──────────────────────────┐
					       │   Database Table (DB)    │
					       │    [101 | Pen | 20]      │
					       └──────────────────────────┘

	 * 
	 * 
	 */
	
	
	public Product saveProductDao(Product product) {
		
		Connection connection = JdbcConnection.getJdbcConnection();
		if (connection == null) {
			System.out.println(
					"-----------Please Check DB Connection! Connection is Not Stablished!!!-----------");
			return null;
		}
		
		String insertProductQuery = "insert into product(id, name, color, price, mfd, expd) values(?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(insertProductQuery);

			ps.setInt(1, product.getId());
			ps.setString(2, product.getName());
			ps.setString(3, product.getColor());
			ps.setDouble(4, product.getPrice());
			ps.setObject(5, product.getMfd());
			ps.setObject(6, product.getExpd());
			int a = ps.executeUpdate();

			return a != 0 ? product : null;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * deleteProductByIdDao(int productId)
	 */

	public boolean deleteProductByIdDao(int productId) {

		Connection connection = JdbcConnection.getJdbcConnection();
		if (connection == null) {
			System.out.println(
					"-----------Please Check DB Connection! Connection is Not Stablished!!!-----------");
			return false;
		}
		String deleteProductById = "DELETE FROM product WHERE id = ?";
		PreparedStatement ps = null;

		try {

			connection.setAutoCommit(false);
			ps = connection.prepareStatement(deleteProductById);
			ps.setInt(1, productId);
			int a = ps.executeUpdate();
			connection.commit();
			return a != 0 ? true : false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	/**
	 * getProductByIdDao(int ProductId)
	 * 
	 * @return Product;
	 */
	public Product getProductByIdDao(int ProductId) {

		Connection connection = JdbcConnection.getJdbcConnection();
		if (connection == null) {
			System.out.println(
					"-----------Please Check DB Connection! Connection is Not Stablished!!!-----------");
			return null;
		}

		String displayProductByIdQuery = " select * from product where id = ?";
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(displayProductByIdQuery);
			ps.setInt(1, ProductId);
			ResultSet set = ps.executeQuery();
			if (set.next()) {
				Product product = new Product();
				int id = set.getInt("id");
				String name = set.getString("name");
				String color = set.getString("color");
				double price = set.getDouble("price");
				LocalDate mfd = set.getDate("mfd").toLocalDate();
				LocalDate expd = set.getDate("expd").toLocalDate();

				product.setId(id);
				product.setName(name);
				product.setColor(color);
				product.setPrice(price);
				product.setMfd(mfd);
				product.setExpd(expd);
				return product;
			}
			return null;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	/**
	 * 
	 * saveAllProductFromCollection(List<Product> product)
	 * 
	 * @return List<Products>
	 */

	public List<Product> saveAllProductFromCollection(List<Product> product) {

		Connection connection = JdbcConnection.getJdbcConnection();
		if (connection == null) {
			System.out.println(
					"-----------Please Check DB Connection! Connection is Not Stablished!!!-----------");
			return null;
		}
		
		String insertProductQuery = "insert into product(id, name, color, price, mfd, expd) values(?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(insertProductQuery);

			for (Product p : product) {

				ps.setInt(1, p.getId());
				ps.setString(2, p.getName());
				ps.setString(3, p.getColor());
				ps.setDouble(4, p.getPrice());
				ps.setObject(5, p.getMfd());
				ps.setObject(6, p.getExpd());
				ps.executeUpdate();
			}
			// return a != 0 ? product : null;
			return product;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	/**
	 * getAllProductDetailsDao()
	 * 
	 * 
	 * @return List<Product>
	 * 
			      ┌────────────────────────────┐
		          │        DATABASE TABLE      │
		          │  (Rows returned by query)  │
		          └───────────────┬────────────┘
		                          │
		                          │  ResultSet.next()
		                          ▼
		          ┌────────────────────────────┐
		          │        RESULTSET ROW       │
		          │  id | name | color | ...   │
		          └───────────────┬────────────┘
		                          │
		                          │  getInt(), getString()
		                          ▼
			     ┌──────────────────────────────────────────┐
			     │     TEMP VARIABLES IN YOUR JAVA CODE     │
			     │   int id, String name, String color ...  │
		         └───────────────┬──────────────────────────┘
			                     │
			                     │  product.setXxx(values)
			                     ▼
			        ┌────────────────────────────┐
			        │      PRODUCT OBJECT        │
			        │  new Product() filled with │
			        │  id, name, color, price…   │
			        └───────────────┬────────────┘
			                        │
			                        │  prods.add(product)
			                        ▼
			         ┌────────────────────────────┐
			         │      LIST<Product>         │
			         │  [ product1, product2 ... ]│
			         └────────────────────────────┘
	 *	         
	 */

	public List<Product> getAllProductDetailsDao() {
		Connection connection = JdbcConnection.getJdbcConnection();
		if (connection == null) {
			System.out.println(
					"-----------Please Check DB Connection! Connection is Not Stablished!!!-----------");
			return null;
		}
		String displayAllProductQuery = "select * from product";
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(displayAllProductQuery);
			ResultSet set = ps.executeQuery();
			List<Product> prods = new ArrayList<>();

			while (set.next()) {
				Product products = new Product();

				int id = set.getInt("id");
				String name = set.getString("name");
				String color = set.getString("color");
				double price = set.getDouble("price");
				LocalDate mfd = set.getDate("mfd").toLocalDate();
				LocalDate expd = set.getDate("expd").toLocalDate();

				products.setId(id);
				products.setName(name);
				products.setColor(color);
				products.setPrice(price);
				products.setMfd(mfd);
				products.setExpd(expd);

				prods.add(products);

			}
			return prods;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		}
		return null;
	}
	
	/**
	 * 
	 * savaMultipleProductDao(List<Product> product)
	 * 
	 * 
	 * @return List<Product>          
	          	    ┌────────────────────────────┐
                    │JdbcConnection.getConnection│
                    └───────────────┬────────────┘
                                    │
                                    ▼
                         ┌──────────────────────┐
                         │   Connection Object  │
                         └──────────┬───────────┘
                                    │
                        Set AutoCommit(false)
                                    │
                                    ▼
                     ┌──────────────────────────────┐
                     │ Prepare SQL Insert Query (?) │
                     └───────────────┬──────────────┘
                                     │
                                     ▼
                        ┌─────────────────────────┐
                        │  Loop Through Products  │
                        └───────────┬─────────────┘
                                    │
              ┌─────────────────────┴──────────────────────┐
              │ Set ? values (id, name, color, price, etc.)│
              └─────────────────────┬──────────────────────┘
                                    │
                                    ▼
                           Add to Batch (ps.addBatch)
                                    │
                                    ▼
                       ┌──────────────────────────┐
                       │Execute Batch (all at once)│
                       └──────────┬──────────────┘
                                  │
                                  ▼
                         Commit Transaction
                                  │
                                  ▼
                    Print Success Message / Return List

	 * 
	 */
	
	
	public List<Product> savaMultipleProductDao(List<Product> products) {
		Connection connection = JdbcConnection.getJdbcConnection();
		if (connection == null) {
			System.out.println(
					"-----------Please Check DB Connection! Connection is Not Stablished!!!-----------");
			return null;
		}
		
		String insertProductQuery = "insert into product(id, name, color, price, mfd, expd) values(?, ?, ?, ?, ?, ?)";

		PreparedStatement ps = null;
		try {

			connection.setAutoCommit(false);
			ps = connection.prepareStatement(insertProductQuery);

			for (Product product : products) {
				ps.setInt(1, product.getId());
				ps.setString(2, product.getName());
				ps.setString(3, product.getColor());
				ps.setDouble(4, product.getPrice());
				ps.setObject(5, product.getMfd());
				ps.setObject(6, product.getExpd());

				ps.addBatch();
			}
			int a[] = ps.executeBatch();
			System.out.println(a.length);
			System.out.println(a == null ? "-----Something went wrong!-----" : "-----Your Data is saved!!!-----");
			connection.commit();
			return products;
		} catch (SQLException e) {
			System.out.println("-------Something Went Wrong, Please Check Your Code!--------");
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return null;
		}

	}
	
	/**
	 * stored procedure
	 * getProductByPriceDao(double Price)
	 * 
	 * @return List<Product>
	 */
	
	
	public List<Product> getProductByPriceDao(double Price){

		Connection connection = JdbcConnection.getJdbcConnection();
		if (connection == null) {
			System.out.println(
					"-----------Please Check DB Connection! Connection is Not Stablished!!!-----------");
			return null;
		}
		
		CallableStatement cls = null;

		try {
			cls = connection.prepareCall("call getProductsByPrice(?)");
			cls.setDouble(1, Price);
			ResultSet set = cls.executeQuery();
			List<Product> prods = new ArrayList<>();

			while (set.next()) {
				Product products = new Product();

				int id = set.getInt("id");
				String name = set.getString("name");
				String color = set.getString("color");
				double price = set.getDouble("price");
				LocalDate mfd = set.getDate("mfd").toLocalDate();
				LocalDate expd = set.getDate("expd").toLocalDate();

				products.setId(id);
				products.setName(name);
				products.setColor(color);
				products.setPrice(price);
				products.setMfd(mfd);
				products.setExpd(expd);

				prods.add(products);

			}
			return prods;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (cls != null) {
				try {
					cls.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		}
		return new ArrayList<>();
	
	}
	
	/**
	 * updateProductDetails(Product product)
	 * 
	 * @return boolean
	 */
	public boolean updateProductDetails(Product product) {

		Connection connection = JdbcConnection.getJdbcConnection();
		if (connection == null) {
			System.out.println("-----------Please Check DB Connection! Connection is Not Stablished!!!-----------");
			return false;
		}

		String updateProductQuery = "update product set name = ?, color = ?, price = ?, mfd = ?, expd = ? where id = ?";

		PreparedStatement ps = null;

		try {
			connection.setAutoCommit(false);
			ps = connection.prepareStatement(updateProductQuery);

			ps.setString(1, product.getName());
			ps.setString(2, product.getColor());
			ps.setDouble(3, product.getPrice());
			ps.setObject(4, product.getMfd());
			ps.setObject(5, product.getExpd());
			ps.setInt(6, product.getId());
			int a = ps.executeUpdate();
			
			connection.commit();

			return a != 0 ? true : false;

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
		}
	}
}

