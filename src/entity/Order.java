package entity;


public class Order{

	private int orderID;
    private int customerID;
    private String orderDate;
    private double totalAmount;

    
    

	public void setorderID(int orderID) {
        this.orderID = orderID;
    }
    
    public int getOrderID() {
        return orderID;
    }
    public void setCustomerID(int customerID) {
       this.customerID=customerID;
   }

    public int getCustomerID() {
         return customerID;
    }
       

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    
//    -----------------------------------------------------

    
    
    
//    ------------------------------------------------------------------------------------------
    
    public String toString() {
        return "Order {" + "Order ID: " + orderID + ", Order Date: " + orderDate + ", Total Amount: $" + totalAmount + ", Customer Details:" + customerID +"}";
    }
    

    

    

}
