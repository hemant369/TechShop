package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDBConnection {

	static Connection con;
	public static Connection getMyDbConnection() {
		try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TechShops ", "root", "R715208441r@");
			}
		catch (SQLException e) {
		
			e.printStackTrace();
		}	
		
		return con;
	}
	
	public static void main(String[] args) {
		System.out.println(getMyDbConnection());
		}	
}
	