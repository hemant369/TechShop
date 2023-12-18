package controller;


import java.util.Scanner;

import dao.ProductDao;
import entity.Product;

public class ProductController implements ProductInterface{
	
	Product product;
	Scanner sc = new Scanner(System.in);
	ProductDao productDao = new ProductDao();

	public void addProduct() {
		
		product = new Product();
		
		System.out.println("Add Product ID:");
		int pid = sc.nextInt();
		product.setProductID(pid);
		
		System.out.println("Add Product Name:");
		String pname = sc.next();
		product.setProductName(pname);
		
		System.out.println("Add Product Description:");
		String pproduct = sc.next();
		product.setDescription(pproduct);
		
		System.out.println("Add Product Price:");
		double pprice = sc.nextDouble();
		product.setPrice(pprice);
		
		
		productDao.insertProduct(product);
	}
	public void getProductDetails() {
        
		System.out.println("Enter Product ID: ");
		int productid = sc.nextInt();
		productDao.showProduct(productid);
    }
	public void updateProductInfo() {
		
		product=new Product();
		
		System.out.println("Enter Product ID: ");
		int productid = sc.nextInt();
		product.setProductID(productid);
		
		System.out.println("Enter Product Name: ");
		String productname = sc.next();
		product.setProductName(productname);
		
		System.out.println("Enter Description: ");
		String productdescription = sc.next();
		product.setDescription(productdescription);
		
		System.out.println("Enter Price: ");
		double productprice = sc.nextDouble();
		product.setPrice(productprice);
		
		productDao.updateProduct(product);
    }

    public void isProductInStock() {
       
        System.out.println("Enter Product ID:");
        int productid = sc.nextInt();
        System.out.println("Enter Quanity: ");
        int quanity = sc.nextInt();
        productDao.isProductInStock(productid,quanity);
    }
}