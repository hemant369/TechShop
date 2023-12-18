package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import entity.Product;
import exception.SqlException;
import util.MyDBConnection;

public class ProductDao {

	Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;
	
	public void insertProduct(Product product) {
		try {
			connection= MyDBConnection.getMyDbConnection();
			ps=connection.prepareStatement("insert into product values(?,?,?,?)");
			ps.setInt(1, product.getProductID());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getDescription());
			ps.setDouble(4, product.getPrice());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted successfully !!!");
		} catch (SQLException e) {
		
			try {
                throw new SqlException();
            } catch (SqlException e1) {
                e1.SqlException();
            }
		}
}
	public void showProduct(int productid) {
		try {
			connection= MyDBConnection.getMyDbConnection();
			ps=connection.prepareStatement("select productid,productname,description,price from product where productID=? ");
			ps.setInt(1, productid);
			rs = ps.executeQuery();
			while(rs.next()) {
                int productID = rs.getInt("productid");
                String productname = rs.getString("productname");
                String description = rs.getString("description");
                Double price = rs.getDouble("price");
                
                System.out.println("ProductID: " + productID);
                System.out.println("Product Name: " + productname);
                System.out.println("Description: " + description);
                System.out.println("Price: " + price);
					} 
			}
		catch (SQLException e) {
		
			try {
                throw new SqlException();
            } catch (SqlException e1) {
                e1.SqlException();
            }
		}
	
	}
	public void updateProduct(Product product) {
		try {
			connection = MyDBConnection.getMyDbConnection();
			ps = connection.prepareStatement("update product set productname=?,description=?,price=? where productID=?");
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setInt(4, product.getProductID());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " updated successfully !!!");
		} catch (SQLException e) {

			try {
                throw new SqlException();
            } catch (SqlException e1) {
                e1.SqlException();
            }
		}
	}
	
	public void isProductInStock(int productid,int requiredquantity) {
		try {
			connection = MyDBConnection.getMyDbConnection();
			ps = connection.prepareStatement("SELECT P.ProductID, P.ProductName, I.QuantityInStock FROM Product P JOIN Inventory I ON P.ProductID = I.ProductID WHERE P.ProductID=?");
			ps.setInt(1, productid);
			rs = ps.executeQuery();
			if (rs.next()) {
                int quantityInStock = rs.getInt("QuantityInStock");

                if (quantityInStock >= requiredquantity) {
                    System.out.println("Product is available.");
                } else {
                    System.out.println("Product is not available.");
                }
            } else {
                System.out.println("Product is not found in Inventory.");
            }
			
		} catch (SQLException e) {
			try {
                throw new SqlException();
            } catch (SqlException e1) {
                e1.SqlException();
            }
		}
	}
	
}

