package main;

import java.util.Scanner;

import controller.CustomerController;
import controller.CustomerInterface;
import controller.ProductInterface;
import controller.OrderInterface;
import controller.OrderDetailsInterface;
import controller.InventoryInterface;
import controller.InventoryController;
import controller.ProductController;
import controller.OrderController;
import controller.OrderDetailsController;
import exception.AuthorizationException;



public class MainClass {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Techshop");
		
		Scanner sc=new Scanner(System.in);
		String username="";
		String password="";
		System.out.println("Enter Username: ");
		username=sc.next();
		System.out.println("Enter Password: ");
		password=sc.next();
		
	try {
		if(username.equals("hemant") && password.equals("hemant"))
			{
				CustomerInterface customerInterface = new CustomerController();
				ProductInterface productInterface = new ProductController();
				OrderInterface orderInterface = new OrderController();
				OrderDetailsInterface orderdetailsInterface = new OrderDetailsController();
				InventoryInterface inventoryInterface = new InventoryController();
				String ch = null;
			
			do {
				
				System.out.println("Select an Option: ");
				System.out.println("1.Customer Section: ");
				System.out.println("2.Product Section: ");
				System.out.println("3.Order Section: ");
				System.out.println("4.OrderDetails Section: ");
				System.out.println("5.Inventory Section: ");
		
				int m=sc.nextInt();
				switch(m)
				{
				case 0: break;
				case 1:
				System.out.println("0. Exit: ");
				System.out.println("1. Add Customer: ");
				System.out.println("2. Calculate Total Orders: ");
				System.out.println("3. Update Customer Details: ");
				System.out.println("4. Get Customer Details: ");
				int c=sc.nextInt();
						switch (c) {
		                case 1:
		                	customerInterface.addCustomer();
		                    break;
		                case 2:
		                	customerInterface.calculateTotalOrders();
		                    break;
		                case 3:
		                	customerInterface.updateCustomer();
		                    break;
		                case 4:
		                	customerInterface.getCustomerDetails();
		                	break;
		                case 0:
		                    System.out.println("Exiting the Customer Section");
		                    break;
		                default:
		                    System.out.println("Invalid choice. Please enter a valid option.");
		                    break;
									}break;
				case 2:
					System.out.println("0. Exit: ");
					System.out.println("1. Add Product: ");
					System.out.println("2. Get Product Details: ");
					System.out.println("3. Update Product Info: ");
					System.out.println("4. Product in Stock: ");
					int p=sc.nextInt();
						switch (p) {
		                case 1:
		                	productInterface.addProduct();
		                    break;
		                case 2:
		                	productInterface.getProductDetails();
		                    break;
		                case 3:
		                	productInterface.updateProductInfo();
		                    break;
		                case 4:
		                	productInterface.isProductInStock() ;
		                	break;
		                case 0:
		                    System.out.println("Exiting the Product Section");
		                    break;
		                default:
		                    System.out.println("Invalid choice. Please enter a valid option.");
		                    break;
									}break;
				case 3:
					System.out.println("0. Exit: ");
					System.out.println("1. Add Order: ");
					System.out.println("2. Show Orders: ");
					System.out.println("3. Total Amount: ");
					System.out.println("4. Sort Order by Date: ");
					int o=sc.nextInt();
						switch (o) {
		                case 1:
		                	orderInterface.addOrder();
		                    break;
		                case 2:
		                	orderInterface.getorder();
		                    break;
		                case 3:
		                	orderInterface.calculateTotalAmount();
		                    break;
		                case 4:
		                	orderInterface.Sortorderbydate();
		                    break;
		               
		                case 0:
		                    System.out.println("Exiting the Order Section");
		                    break;
		                default:
		                    System.out.println("Invalid choice. Please enter a valid option.");
		                    break;
									}break;
				case 4:
					System.out.println("0. Exit: ");
					System.out.println("1. Add Order Details: ");
					System.out.println("2. Calculate Subtotal: ");
					System.out.println("3. Get order Details: ");
					System.out.println("4. Update Quantity: ");
					System.out.println("5. Add Discount: ");
					int oo=sc.nextInt();
						switch (oo) {
		                case 1:
		                	orderdetailsInterface.addOrderDetails();
		                    break;
		                case 2:
		                	orderdetailsInterface.calculateSubtotal();
		                    break;
		                case 3:
		                	orderdetailsInterface.getOrderDetails();
		                    break;
		                case 4:
		                	orderdetailsInterface.updateQuantity();
		                    break;
		                case 5:
		                	orderdetailsInterface.addDiscount();
		                    break;
		                case 0:
		                    System.out.println("Exiting the Order Details Section");
		                    break;
		                default:
		                    System.out.println("Invalid choice. Please enter a valid option.");
		                    break;
									}break;
				case 5:		
						System.out.println("0. Exit: ");
						System.out.println("1. Add in Inventory: ");
						System.out.println("2. Get Product: ");
						System.out.println("3. Get Quantity In Stock: ");
						System.out.println("4. Remove from Inventory: ");
						System.out.println("5. Update Stock Quantity: ");
						System.out.println("6. Is Product Available: ");
						System.out.println("7. Get Inventory values: ");
						System.out.println("8. Low Stock Products: ");
						System.out.println("9. Out of Stock Products: ");
						System.out.println("10. List all Products With Quantity: ");
						System.out.println("11. Sort By Product ID: ");
						int i=sc.nextInt();
							switch (i) {
			                case 1:
			                	inventoryInterface.addInventory();
			                    break;
			                case 2:
			                	inventoryInterface.getProduct();
			                    break;
			                case 3:
			                	inventoryInterface.getQuantityInStock();
			                    break;
			                case 4:
			                	inventoryInterface.removeFromInventory();
			                    break;
			                case 5:
			                	inventoryInterface.updateStockQuantity();
			                    break;
			                case 6:
			                	inventoryInterface.isProductAvailable();
			                    break;
			                case 7:
			                	inventoryInterface.getInventory();
			                    break;   
			                case 8:
			                	inventoryInterface.listLowStockProducts();
			                    break;   
			                case 9:
			                	inventoryInterface.listOutOfStockProducts();
			                    break;
			                case 10:
			                	inventoryInterface.listAllProducts();
			                    break;
			                case 11:
			                	inventoryInterface.SortByProductID();
			                    break;
			                case 0:
			                    System.out.println("Exiting the Inventory Section");
			                    break;
			                default:
			                    System.out.println("Invalid choice. Please enter a valid option.");
			                    break;
										}
					}
				System.out.println("Do you want to continue? Y | y ");
				ch = sc.next();
				}while (ch.equals("Y") || ch.equals("y"));
			System.out.println("Thank You for Using Our System!!!");
		}
		else
		{
			throw new AuthorizationException();
		}
			
	}
		catch(AuthorizationException e)
		{
			System.out.println(e);
		}
	}
}