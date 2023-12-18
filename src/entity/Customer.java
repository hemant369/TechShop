package entity;

import exception.InvalidDataException;

public class Customer {
	
	private int customerID;
	private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
     
    
    public void setCustomerID(int customerID) {
        this.customerID=customerID;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setEmail(String email) {
    	
    	try
    	{
    		if(email!=null && email.contains("@") && email.contains(".com")) 
    		{
    			this.email = email;
    		}
    		else 
    		{
				throw new InvalidDataException();
    		}
    	}
    	catch (InvalidDataException e){
    		System.out.println(e);
    		
    	}
        
    }
    
    public void setPhone(String phone) {
    	try {
    		if (phone.matches("\\d{10}")) {
    			this.phone = phone;
    		} 
    		else {
    			throw new InvalidDataException();
    		}
    	}
    	catch(InvalidDataException e) {
    		System.out.println(e);
    	}
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public int getCustomerID() {
        return customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
	
	public int calculateTotalOrders() 
	{
        return 0; 
    }
	
	public String tostring() {
	
		return "Customer [CustomerID=" + customerID + ", FirstName=" + firstName + ", LastName=" + lastName + ", Email="+email+", Phone="+phone+", Address="+address+"]";
	}
	
}
