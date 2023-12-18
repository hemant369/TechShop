package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Inventory;
import entity.Order;
import exception.SqlException;
import util.MyDBConnection;
import exception.SqlException;

public class InventoryDao {

	Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet rs;

	public void insertInventory(Inventory inventory) {
		try {
			connection= MyDBConnection.getMyDbConnection();
			ps=connection.prepareStatement("insert into inventory values(?,?,?,?)");
			ps.setInt(1,inventory.getInventoryID());
			ps.setInt(2, inventory.getproductID()); 
			ps.setInt(3, inventory.getQuantityInStock());
			ps.setString(4, inventory.getLastStockUpdate());
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows + " inserted successfully !!!");
		}catch (SQLException e) {

			try {
                throw new SqlException();
            } catch (SqlException e1) {
                e1.SqlException();
           }
		}
}
	public void showInventory() {
		try {
			connection= MyDBConnection.getMyDbConnection();
			statement= connection.createStatement();
			rs=statement.executeQuery("select * from inventory");
			while(rs.next()) {
				System.out.println("InventoryID  : " + rs.getInt(1));
				System.out.println("ProductID : " + rs.getInt(2));
				System.out.println("Quantity In Stock  : " + rs.getInt(3));
				System.out.println("Last Stock Update  : " + rs.getString(4));
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
	public void getProduct(int inventoryID) {
		try {
			connection = MyDBConnection.getMyDbConnection();
			ps = connection.prepareStatement("SELECT p.ProductName FROM Inventory i JOIN Product p ON i.ProductID = p.ProductID WHERE i.ProductID = ?");
			ps.setInt(1, inventoryID);
			rs = ps.executeQuery();
			if (rs.next()) {
                int inventoryId = rs.getInt("InventoryID");
                String productName = rs.getString("ProductName");

                System.out.println("Inventory ID: " + inventoryId);
                System.out.println("Product Name: " + productName);
               
            } else {
                System.out.println("No Product found for the specified Inventory ID in Inventory.");
            }
			
		} catch (SQLException e) {

			try {
                throw new SqlException();
            } catch (SqlException e1) {
                e1.SqlException();
           }
		}
	}
	public void getQuantityInStock(String productname) {
		try {
			connection = MyDBConnection.getMyDbConnection();
			ps = connection.prepareStatement("SELECT p.ProductName,i.QuantityInStock  FROM Inventory i JOIN Product p ON i.ProductID = p.ProductID WHERE p.productname = ?");
			ps.setString(1, productname);
			rs = ps.executeQuery();
			if (rs.next()) {
                String productname1 = rs.getString("ProductName");
                int quantityinstock = rs.getInt("QuantityinStock");

                System.out.println("Product Name: " + productname1);
                System.out.println("Quantity in Stock: " + quantityinstock);
               
            } else {
                System.out.println("No Quanity in Stock found for the specified Product ID in Inventory.");
            }
			
		} catch (SQLException e) {

			try {
                throw new SqlException();
            } catch (SqlException e1) {
                e1.SqlException();
           }
		}
	}
	public void updateStockQuantity(Inventory inventory) {
		try {
			connection = MyDBConnection.getMyDbConnection();
			ps = connection.prepareStatement("update inventory set quantityinstock=? where inventoryID=?");
			ps.setDouble(1, inventory.getQuantityInStock());
			ps.setInt(2, inventory.getInventoryID());
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
	public void isProductAvailable(int productid, int quantity) {
		try {
			connection = MyDBConnection.getMyDbConnection();
			ps = connection.prepareStatement("SELECT QuantityInStock FROM Inventory WHERE ProductID = ?");
			ps.setInt(1, productid);
			rs = ps.executeQuery();
			if (rs.next()) {
                int quantityInStock = rs.getInt("QuantityInStock");

                if (quantityInStock >= quantity) {
                    System.out.println("Quanity is available.");
                } else {
                    System.out.println("Quanity is not available.");
                }
            } else {
                System.out.println("Quanity is not found in Inventory.");
            }
			
		} catch (SQLException e) {

			try {
                throw new SqlException();
            } catch (SqlException e1) {
                e1.SqlException();
            }
		}
	}
	public void listLowStockProducts(int thresholdquantity) {
		try {
			connection = MyDBConnection.getMyDbConnection();
			ps = connection.prepareStatement("SELECT p.ProductName, i.QuantityInStock FROM Inventory i JOIN Product p ON i.ProductID = p.ProductID WHERE i.QuantityInStock < ?");
			ps.setInt(1, thresholdquantity);
			rs = ps.executeQuery();
			while (rs.next()) {
                String productName = rs.getString("ProductName");
                int quantityInStock = rs.getInt("QuantityInStock");

                System.out.println("Low stock Product: " + productName);
                System.out.println("Quantity in stock: " + quantityInStock);
            }
			
		} catch (SQLException e) {

			try {
                throw new SqlException();
            } catch (SqlException e1) {
                e1.SqlException();
            }
		}
	}
	 public void listAllProducts() {
		 try {
				connection = MyDBConnection.getMyDbConnection();
				ps = connection.prepareStatement("SELECT p.ProductName, i.QuantityInStock FROM Inventory i JOIN Product p ON i.ProductID = p.ProductID");
				rs = ps.executeQuery();
				while (rs.next()) {
	                String productName = rs.getString("ProductName");
	                int quantityInStock = rs.getInt("QuantityInStock");

	                System.out.println("Low stock Product: " + productName);
	                System.out.println("Quantity in stock: " + quantityInStock);
	            }
				
			} catch (SQLException e) {

				try {
	                throw new SqlException();
	            } catch (SqlException e1) {
	                e1.SqlException();
	            }
			}
	 }
	 public void listOutOfStockProducts() {
		 try {
				connection = MyDBConnection.getMyDbConnection();
				ps = connection.prepareStatement("SELECT p.ProductName, i.QuantityInStock FROM Inventory i JOIN Product p ON i.ProductID = p.ProductID WHERE i.QuantityInStock is Null");
				rs = ps.executeQuery();
				while (rs.next()) {
	                String productName = rs.getString("ProductName");
	                int quantityInStock = rs.getInt("QuantityInStock");

	                System.out.println("Product Name: " + productName);
	                System.out.println("Quantity in stock: " + quantityInStock);
	            }
			} catch (SQLException e) {
				try {
	                throw new SqlException();
	            } catch (SqlException e1) {
	                e1.SqlException();
	            }
			}
	 }
	public void removeFromInventory(int inventoryID) {
		 try {
				connection = MyDBConnection.getMyDbConnection();
				ps = connection.prepareStatement("delete from inventory where inventoryID=?");
				ps.setInt(1, inventoryID);
				int noofrows = ps.executeUpdate();
				System.out.println(inventoryID + " deleted successfully !!!");
			} catch (SQLException e) {
				try {
	                throw new SqlException();
	            } catch (SqlException e1) {
	                e1.SqlException();
	            }
			}
		}
public List<Inventory> SortByProductID() {
		
		List<Inventory>inventorylist=new ArrayList<>();
		try {
			connection = MyDBConnection.getMyDbConnection();
			ps = connection.prepareStatement("select * from inventory ");
			rs = ps.executeQuery();
			 while (rs.next()) {
				 Inventory inventory = new Inventory();
				 inventory.setinventoryID(rs.getInt(1));
				 inventory.setProductID(rs.getInt(2));
				 inventory.setQuantityInStock(rs.getInt(3));
				 inventory.setLastStockUpdate(rs.getString(4));
	                

	             inventorylist.add(inventory);
	            }
			
		} catch (SQLException e) {
			try {
                throw new SqlException();
            } catch (SqlException e1) {
                e1.SqlException();
            }
		}
		return inventorylist;
	}
}
