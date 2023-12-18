package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.OrderDetails;
import exception.SqlException;
import util.MyDBConnection;

public class OrderDetailsDao {
	Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;

	public void insertOrderDetails(OrderDetails orderdetail) {
		try {
			connection= MyDBConnection.getMyDbConnection();
			ps=connection.prepareStatement("insert into orderdetail values(?,?,?,?)");
			ps.setInt(1,orderdetail.getOrderDetailID());
			ps.setInt(2, orderdetail.getOrderID()); 
			ps.setInt(3, orderdetail.getProductID());
			ps.setInt(4, orderdetail.getQuantity());
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
	public void showOrderDetails() {
		try {
			connection= MyDBConnection.getMyDbConnection();
			statement= connection.createStatement();
			rs=statement.executeQuery("select * from orderdetail");
			while(rs.next()) {
				System.out.println("OrderDetailsID  : " + rs.getInt(1));
				System.out.println("ProductID : " + rs.getInt(2));
				System.out.println("OrderID  : " + rs.getInt(3));
				System.out.println("Quantity  : " + rs.getInt(4));
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
	public void calculateSubtotal(int orderdetailid) {
		try {
			connection = MyDBConnection.getMyDbConnection();
			ps = connection.prepareStatement("SELECT od.Quantity * p.Price AS TotalCost FROM OrderDetail od JOIN Product p ON od.ProductID = p.ProductID WHERE od.OrderDetailID = ?");
			ps.setInt(1, orderdetailid);
			rs = ps.executeQuery();
			if (rs.next()) {
                double totalCost = rs.getDouble("TotalCost");
                System.out.println("Total Cost: " + totalCost);
            } else {
                System.out.println("No records found for the specified order detail ID.");
            }	
		} catch (SQLException e) {

			try {
                throw new SqlException();
            } catch (SqlException e1) {
                e1.SqlException();
            }
		}
	}
	public void updateQuantity(OrderDetails orderdetail) {
		try {
			connection = MyDBConnection.getMyDbConnection();
			ps = connection.prepareStatement("update orderdetail set quantity=? where orderdetailID=?");
			ps.setInt(1, orderdetail.getQuantity());
			ps.setInt(2, orderdetail.getOrderDetailID());
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
	public void addDiscount(int orderdetailid,int discount) {
		try {
			connection = MyDBConnection.getMyDbConnection();
			ps = connection.prepareStatement("SELECT od.Quantity * p.Price AS TotalCost FROM OrderDetail od JOIN Product p ON od.ProductID = p.ProductID WHERE od.OrderDetailID = ?");
			ps.setInt(1, orderdetailid);
			rs = ps.executeQuery();
			if (rs.next()) {
                double totalCost = rs.getDouble("TotalCost");
                System.out.println("Before Discount: " + totalCost);
                double Final=totalCost-discount;
                System.out.println("After Discount: " + Final);
            } else {
                System.out.println("No records found for the specified order detail ID.");
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
