package entity;


public class Product {
			
	 private int productID;
	 private String productName;
	 private String description;
	 private double price;

//	 public Product(Int productID, String productName, String description, double price) 
//	 	{
//	        this.productID = productID;
//	        this.productName = productName;
//	        this.description = description;
//	        this.price = price;
//	    }
	 

		public void setProductID(int productID) {
	        this.productID = productID;
	    }

	 	
	 	public int getProductID() {
	        return productID;
	    }

	    public String getProductName() {
	        return productName;
	    }

	    public void setProductName(String productName) {
	        this.productName = productName;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	    	if (price >= 0) {
	            this.price = price;
	        } else {
	            System.out.println("Invalid price. Please provide a non-negative value.");
	        }
	    }
	    
//	  ------------------------------------------------------------------------------------------

	    public String toString() {
	        return "Product{" +
	                "productID=" + productID +
	                ", productName='" + productName + '\'' +
	                ", description='" + description + '\'' +
	                ", price=" + price +
	                '}';
	    }

	    
	}

