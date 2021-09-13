package com.niit.E_CommerceBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ECommerceBackend.DAO.CategoryDAO;
import com.niit.ECommerceBackend.DAO.ProductDAO;
import com.niit.ECommerceBackend.model.Category;
import com.niit.ECommerceBackend.model.Product;

public class ProductTest 
{
	private static AnnotationConfigApplicationContext context;

	static private ProductDAO productDAO;
	static private Product product;
	

	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.ECommerceBackend");
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	
	@Test	
	public void testAddProduct() 
	{
		product = new Product();
		product.setName("MSI GE66 Raider");
		product.setBrand("MSI");
		product.setCategoryId(1);
		product.setSupplierId(2);
		product.setDescription("This MSI laptop is designed to take your gaming experience a notch higher. While its multiple connectivity ports help you connect various peripherals and devices to it conveniently");
		product.setUnitPrice(194990);
		product.setActive(true);
		product.setQuantity(12);
		
		
		assertEquals("Error adding product" , true , productDAO.addProduct(product));		
		
		
	}
	
}
