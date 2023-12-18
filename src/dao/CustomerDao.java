package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Customer;
import exception.SqlException;
import util.MyDBConnection;


public class CustomerDao {
	
	Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;
	
	public void insertCustomer(Customer customer) {
		try {
			connection= MyDBConnection.getMyDbConnection();
			ps=connection.prepareStatement("insert into Customer values(?,?,?,?,?,?)");
			ps.setInt(1, customer.getCustomerID());
			ps.setString(2, customer.getFirstName());
			ps.setString(3, customer.getLastName());
			ps.setString(4, customer.getEmail());
			ps.setString(5, customer.getPhone());
			ps.setString(6, customer.getAddress());
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
	public void showCustomer(int customerID) {
		try {
			connection= MyDBConnection.getMyDbConnection();
			ps=connection.prepareStatement("select customerid,firstname,lastname,email,phone,address from customer where customerID=? ");
			ps.setInt(1, customerID);
			rs = ps.executeQuery();
			while(rs.next()) {
				int cID = rs.getInt("customerid");
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                
                System.out.println("CustomerID: " + cID);
                System.out.println("Name: " + firstName + " " + lastName);
                System.out.println("Email: " + email);
                System.out.println("Phone: " + phone);
                System.out.println("Address: " + address);
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
	public void calculateTotalOrders(int customerID) {
		try {
			connection = MyDBConnection.getMyDbConnection();
			ps=connection.prepareStatement("SELECT c.CustomerID, c.FirstName, c.LastName, COUNT(o.OrderID) AS TotalOrders FROM Customer c LEFT JOIN Orders o ON c.CustomerID = o.CustomerID WHERE c.CustomerID = ? GROUP BY c.CustomerID, c.FirstName, c.LastName");
			ps.setInt(1, customerID);
			rs = ps.executeQuery();
			while (rs.next()) {
                int cID = rs.getInt("CustomerID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                int totalOrders = rs.getInt("TotalOrders");

                System.out.println("CustomerID: " + cID);
                System.out.println("Customer Name: " + firstName+lastName);
                System.out.println("Total Orders: " + totalOrders);
			}
		} catch (SQLException e) {

			try {
                throw new SqlException();
            } catch (SqlException e1) {
                e1.SqlException();
            }
		}
		
	}
	public void updateCustomer(Customer customer) {
		try {
			connection = MyDBConnection.getMyDbConnection();
			ps = connection.prepareStatement("update customer set firstname=?,lastname=?,email=?,phone=?,address=? where customerID=?");
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getEmail());
			ps.setString(4, customer.getPhone());
			ps.setString(5, customer.getAddress());
			ps.setInt(6, customer.getCustomerID());
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
}
