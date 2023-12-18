package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Order;
import exception.SqlException;
import util.MyDBConnection;

public class OrderDao {
	
	Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;

	public void insertOrder(Order orders) {
		try {
			connection= MyDBConnection.getMyDbConnection();
			ps=connection.prepareStatement("insert into orders values(?,?,?,?)");
			ps.setInt(1, orders.getOrderID());
			ps.setInt(2, orders.getCustomerID()); // customer id
			ps.setString(3, orders.getOrderDate());
			ps.setDouble(4, orders.getTotalAmount());
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
	public void showOrder() {
		try {
			connection= MyDBConnection.getMyDbConnection();
			statement= connection.createStatement();
			rs=statement.executeQuery("select * from orders");
			while(rs.next()) {
				System.out.println("OrderID  : " + rs.getInt(1));
				System.out.println("CustomerID : " + rs.getInt(2));
				System.out.println("Date  : " + rs.getString(3));
				System.out.println("Total Amount  : " + rs.getDouble(4));
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
	public void calculateTotalAmount(int orderID) {
		try {
			connection = MyDBConnection.getMyDbConnection();
			ps = connection.prepareStatement("select orderID,totalamount from orders where orderID = ?");
			ps.setInt(1, orderID);
			rs = ps.executeQuery();
			if (rs.next()) {
                double Quantity = rs.getDouble("totalamount");
                int orderid = rs.getInt("orderID");
                
                System.out.println("Order ID: " + orderid);
                System.out.println("Total Amount: " + Quantity);
               
            } else {
                System.out.println("No Total Amount found for given Order ID.");
            }
			
		} catch (SQLException e) {

			try {
                throw new SqlException();
            } catch (SqlException e1) {
                e1.SqlException();
            }
		}
	}
	public List<Order> Sortorderbydate() {
		
		List<Order>orderslist=new ArrayList<>();
		try {
			connection = MyDBConnection.getMyDbConnection();
			ps = connection.prepareStatement("select * from orders ");
			rs = ps.executeQuery();
			 while (rs.next()) {
				 Order order = new Order();
				 order.setorderID(rs.getInt(1));
				 order.setCustomerID(rs.getInt(2));
				 order.setOrderDate(rs.getString(3));
				 order.setTotalAmount(rs.getDouble(4));
	                

	             orderslist.add(order);
	            }
			
		} catch (SQLException e) {
			try {
                throw new SqlException();
            } catch (SqlException e1) {
                e1.SqlException();
            }
		}
		return orderslist;
	}
	
}
