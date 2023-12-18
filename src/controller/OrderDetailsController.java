package controller;


import java.util.Scanner;

import dao.OrderDetailsDao;
import entity.OrderDetails;

public class OrderDetailsController implements OrderDetailsInterface {

	OrderDetails od = new OrderDetails();
	OrderDetailsDao dao = new OrderDetailsDao();
	Scanner sc = new Scanner(System.in);
	
	public void addOrderDetails() {
		
		System.out.println("Add OrderDetails ID:");
		int odid = sc.nextInt();
		od.setOrderDetialsID(odid);
		
		System.out.println("Add Product ID:");
		int oproductid = sc.nextInt();
		od.setProductID(oproductid);
		
		System.out.println("Add Order ID:");
		int oorderid = sc.nextInt();
		od.setOrderID(oorderid);
		
		
		System.out.println("Add Quantity:");
		int odquantity = sc.nextInt();
		od.setQuantity(odquantity);
		
		
		dao.insertOrderDetails(od);
	}
	public void getOrderDetails() {
        
		dao.showOrderDetails();
    }
	 public void calculateSubtotal() {
	    System.out.println("Enter Order Details ID: ");
	    int orderdetailid=sc.nextInt();
	        
	    dao.calculateSubtotal(orderdetailid);
	}
	 public void updateQuantity() {
	    	
		System.out.println("Enter Order Details ID: ");
	    int orderdetailid=sc.nextInt();
	    od.setOrderDetialsID(orderdetailid);
	    	
	    System.out.println("Enter Quantity: ");
	    int quantity=sc.nextInt();
	    od.setQuantity(quantity);
	    	
	    dao.updateQuantity(od);
	 }
	   public void addDiscount() {
	    	
		System.out.println("Enter Order Details ID: ");
	    int orderdetailid=sc.nextInt();
	    	
	    System.out.println("Enter Discount: ");
	    int orderdiscount=sc.nextInt();
	    	
	    dao.addDiscount(orderdetailid,orderdiscount);
	 }
}