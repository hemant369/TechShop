package controller;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import dao.OrderDao;
import entity.Order;


public class OrderController implements OrderInterface {

	Order order;
	OrderDao orderDao = new OrderDao();
	Scanner sc = new Scanner(System.in);
	
	
	public void addOrder() {
		order = new Order();
		
		System.out.println("Add Order ID:");
		int oid = sc.nextInt();
		order.setorderID(oid);
		
		System.out.println("Customer ID:");
		int ocustomerID = sc.nextInt();
		order.setCustomerID(ocustomerID);
		
		System.out.println("Add OrderDate (YYYY-MM-DD) :");
		String cLastName = sc.next();
		order.setOrderDate(cLastName);
		
		System.out.println("Add Total Amount:");
		int oamount = sc.nextInt();
		order.setTotalAmount(oamount);
		
		orderDao.insertOrder(order);
	}
	
	public void getorder() {
		orderDao.showOrder();
    }
	
	public void calculateTotalAmount() {
        System.out.println("Enter Order ID: ");
        int orderid = sc.nextInt();
        
        orderDao.calculateTotalAmount(orderid);     
    }
	public void Sortorderbydate() {
		List<Order> orderlist = orderDao.Sortorderbydate();
		Collections.sort(orderlist, Comparator.comparing(Order::getOrderDate));
		System.out.println(orderlist);
	}
}