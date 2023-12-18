package entity;

import exception.InsufficientStockException;

public class Inventory {

	  private int inventoryID;
	  private int productID;
	  private int quantityInStock;
	  private String lastStockUpdate;

	  
	  public void setinventoryID(int inventoryID) {
	        this.inventoryID = inventoryID;
	    }
	  
	  public int getInventoryID() {
	        return inventoryID;
	    }
	  
	  public void setProductID(int productID) {
	        this.productID = productID;
	    }
	  public int getproductID() {
	        return productID;
	    }
	  
	  public void setQuantityInStock(int quantityInStock) {
	    	try {
	        	if (quantityInStock < 1000)
	        		{
	                this.quantityInStock = quantityInStock;
	        		} 
	        	else
	        		{
	            	throw new InsufficientStockException();
	        		}
	        	}
	        	catch(InsufficientStockException e)
	        	{
	        		System.out.println(e);
	        	}
	    }
	    public int getQuantityInStock() {
	        return quantityInStock;
	    }

	    public String getLastStockUpdate() {
	        return lastStockUpdate;
	    }
	    public void setLastStockUpdate(String lastStockUpdate ) {
	        this.lastStockUpdate=lastStockUpdate;
	    }
	    
//	    --------------------------------------------------------------
	    
	    public String toString() {
	        return "Inventory ID:" + inventoryID + ", Quantity in Stock: " + quantityInStock + ", LastStockUpdate:" + lastStockUpdate+", ProductID: "+productID;
	    }
	    
//	    ------------------------------------------------------------------

	   
}
