package entity;



public class OrderDetails extends Product {

	private int orderDetailID;
    private int orderID;
    private int productID;
    private int quantity;
    
    public void setOrderDetialsID(int orderdetailID) {
        this.orderDetailID = orderdetailID;
    }

    public int getOrderDetailID() {
        return orderDetailID;
    }
    
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getOrderID() {
        return orderID;
    }
    
    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getProductID() {
        return productID;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getQuantity() {
        return quantity;
    }  
    
//    ------------------------------------------------------------------------------------
    
    
    public String toString() {
        return "Order Detail:" + "Order Detail ID: " + orderDetailID + "\nQuantity: " + quantity +"ProductID: "+ productID+"OrderID: "+orderID;
    }
    
   
}
