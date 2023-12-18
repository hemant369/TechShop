package controller;

public interface InventoryInterface {

	public void addInventory(); 
	public void getProduct();
	public void getQuantityInStock();
	public void removeFromInventory();
	public void updateStockQuantity();
	public void isProductAvailable();
	public void getInventory();
	public void listLowStockProducts();
	public void listOutOfStockProducts();
	public void listAllProducts();
	public void SortByProductID();
}
