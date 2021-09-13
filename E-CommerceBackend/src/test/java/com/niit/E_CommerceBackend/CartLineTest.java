package com.niit.E_CommerceBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ECommerceBackend.DAO.CartLineDAO;
import com.niit.ECommerceBackend.DAO.ProductDAO;
import com.niit.ECommerceBackend.DAO.UserDAO;
import com.niit.ECommerceBackend.model.CartLine;



public class CartLineTest 
{
	private static AnnotationConfigApplicationContext context;

	
	static CartLine cartLine;
	static CartLineDAO cartLineDAO;
	
	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.ECommerceBackend");
		context.refresh();
		
		cartLineDAO = (CartLineDAO)context.getBean("cartLineDAO");
	}
	
	@Test	
	public void testAddCartLine() 
	{
		cartLine = new CartLine();
		cartLine.setAvailable(true);
		cartLine.setBuyingPrice(22990);
		cartLine.setCartId(1);
		cartLine.setProductCount(4);
		cartLine.setTotal(56900);
		
		assertEquals("Error adding user" , true, cartLineDAO.add(cartLine));
		
		
		
	}
	

}
