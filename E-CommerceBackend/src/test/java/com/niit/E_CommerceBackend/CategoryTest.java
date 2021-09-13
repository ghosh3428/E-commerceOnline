package com.niit.E_CommerceBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ECommerceBackend.DAO.CategoryDAO;
import com.niit.ECommerceBackend.model.Category;




public class CategoryTest 
{
	private static AnnotationConfigApplicationContext context;

	static private CategoryDAO categoryDAO;
	static private Category category;
	

	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.ECommerceBackend");
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
	
	@Test	
	public void testAddUser() 
	{
		category = new Category();
		category.setName("Headphone");
		category.setDesc("Sample category for Headphone");
		
		//1. Error message , 2. Expected result , 3. Actual Result
		assertEquals("Error adding Category",true,categoryDAO.addCategory(category));
		
		
	}
	
	/*
	@Test	
	public void testUpdateCategory() 
	{
		category = categoryDAO.getCategory(3);
		category.setName("Television");
		assertEquals("Error adding user",true,categoryDAO.updateCategory(category));
		
		
	}
	
	
	@Test
	public void testCategoryList() 
	{
		assertEquals("Error adding user",4,categoryDAO.categoryList().size());
		
		
	}
*/
}
