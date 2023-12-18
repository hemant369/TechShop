package controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import dao.InventoryDao;
import entity.Inventory;

public class InventoryController implements InventoryInterface {

	Inventory inventory;
	InventoryDao inventoryDao = new InventoryDao();
	Scanner sc = new Scanner(System.in);
	
	public void addInventory() {
		
		inventory = new Inventory();
		System.out.println("Add Inventory ID:");
		int inid = sc.nextInt();
		inventory.setinventoryID(inid);
		
		System.out.println("Add Product ID:");
		int inproductID = sc.nextInt();
		inventory.setProductID(inproductID);
		
		
		System.out.println("Add Quantity in Stock:");
		int inquantitystock = sc.nextInt();
		inventory.setQuantityInStock(inquantitystock);
		
		System.out.println("Add LastStockUpdate:");
		String inlaststockupdate = sc.next();
		inventory.setLastStockUpdate(inlaststockupdate);
		
		inventoryDao.insertInventory(inventory);
	}
	public void getInventory()  {
		
		inventoryDao.showInventory();
    }
	
	public void getProduct() {
        
		System.out.println("Enter Inventory ID: ");
        int inventoryid = sc.nextInt();
        inventoryDao.getProduct(inventoryid);
    }

    public void getQuantityInStock() {
    	
    	System.out.println("Enter Product Name: ");
        String productname = sc.next();
        inventoryDao.getQuantityInStock(productname);
    }	    
    

    public void removeFromInventory() {
    	
    	System.out.println("Enter Inventory ID to delete");
		int inventoryid = sc.nextInt();			
		
		inventoryDao.removeFromInventory(inventoryid);
    }

    public void updateStockQuantity() {
    	inventory = new Inventory();
    	
    	System.out.println("Enter Inventory ID: ");
    	int inventoryid = sc.nextInt();
        inventory.setinventoryID(inventoryid);
        
        System.out.println("Enter New Stock Quantity: ");
    	int stockquantity = sc.nextInt();
        inventory.setQuantityInStock(stockquantity);
        
        inventoryDao.updateStockQuantity(inventory);
    }

    public void isProductAvailable() {
        System.out.println("Enter Product ID: ");
        int productid = sc.nextInt();
        System.out.println("Enter Quantity: ");
        int quanity = sc.nextInt();
        
        inventoryDao.isProductAvailable(productid,quanity);
    }

    public void listLowStockProducts() {
       System.out.println("Enter Maximum Quantity:");
       int thresholdquantity = sc.nextInt();
       inventoryDao.listLowStockProducts(thresholdquantity);
    }

    public void listOutOfStockProducts() {
       inventoryDao.listOutOfStockProducts();
    }

    public void listAllProducts() {
        inventoryDao.listAllProducts();
    }
    public void SortByProductID() {
		List<Inventory> inventorylist = inventoryDao.SortByProductID();
		Collections.sort(inventorylist, Comparator.comparingInt(inventory -> inventory.getproductID()));
		System.out.println(inventorylist);
	}

}