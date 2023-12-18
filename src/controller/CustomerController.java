package controller;


import java.util.Scanner;

import dao.CustomerDao;
import entity.Customer;

public class CustomerController implements CustomerInterface  {
	
	Customer customer;
	Scanner sc=new Scanner(System.in);
	CustomerDao customerDao = new CustomerDao();

	public void addCustomer()
	{
		customer=new Customer();
		
		System.out.println("Add Customer ID:");
		int cid=sc.nextInt();
		customer.setCustomerID(cid);
		
		System.out.println("Add Customer FirstName:");
		String cFirstName=sc.next();
		customer.setFirstName(cFirstName);
		
		System.out.println("Add Customer lastName:");
		String cLastName=sc.next();
		customer.setLastName(cLastName);
		
		System.out.println("Add Customer Email:");
		String cEmail=sc.next();
		customer.setEmail(cEmail);
		
		System.out.println("Add Customer Phone Number:");
		String cPhone=sc.next();
		customer.setPhone(cPhone);
		
		System.out.println("Add Customer Address:");
		String cAddress=sc.next();
		customer.setAddress(cAddress);
		
		customerDao.insertCustomer(customer);
	}
	
	public void getCustomerDetails() 
    {		
		System.out.println("Enter Customer ID:");
		int customerid=sc.nextInt();
		customerDao.showCustomer(customerid);
    }

	public void calculateTotalOrders() {
		System.out.println("Enter Customer ID:");
		int customerid=sc.nextInt();
		customerDao.calculateTotalOrders(customerid);
	}

public void updateCustomer() {
		
		customer=new Customer();
		
		System.out.println("Enter your Customer ID");
		int customerno = sc.nextInt();
		customer.setCustomerID(customerno);

		System.out.println("Enter your First Name to Update");
		String customerfirstname = sc.next();
		customer.setFirstName(customerfirstname);
		
		System.out.println("Enter your Last Name to Update");
		String customerlastname = sc.next();
		customer.setLastName(customerlastname);
		
		System.out.println("Enter your Email to Update");
		String customeremail = sc.next();
		customer.setEmail(customeremail);
		
		System.out.println("Enter your Phone Number to Update");
		String customerphone = sc.next();
		customer.setPhone(customerphone);
		
		System.out.println("Enter your Address to Update");
		String customeraddress = sc.next();
		customer.setAddress(customeraddress);
		
		customerDao.updateCustomer(customer);
	}

}
