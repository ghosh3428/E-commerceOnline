package com.niit.E_CommerceBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ECommerceBackend.DAO.CategoryDAO;
import com.niit.ECommerceBackend.DAO.UserDAO;
import com.niit.ECommerceBackend.model.Address;
import com.niit.ECommerceBackend.model.Cart;
import com.niit.ECommerceBackend.model.Category;
import com.niit.ECommerceBackend.model.User;

public class UserTest 
{
	private static AnnotationConfigApplicationContext context;

	static private UserDAO userDAO;
	static private User user;
	static private Address address;
	static private Cart cart;
	

	@BeforeClass
	public static void init() 
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.ECommerceBackend");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
	}
	
	
	@Test	
	public void testAddCategory() 
	{
		
		
		user = new User();
		user.setFirstName("Sumit");
		user.setLastName("Das");
		user.setRole("USER");
		user.setContactNumber("9087654233");
		user.setEmail("sd@gmail.com");
		user.setPassword("12345");
		user.setEnabled(true);
		if(user.getRole().equals("USER"))
		{
		
			cart = new Cart();
		
			cart.setUser(user);
			
			user.setCart(cart);
		}
		
		assertEquals("Error adding user" , true, userDAO.addUser(user));
		
		
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		address.setUserId(user.getId());
			
		assertEquals("Failed to add the billing address!", true, userDAO.addAddress(address));
		
	
		address = new Address();
		address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
		address.setAddressLineTwo("Near Kudrat Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setShipping(true);
		address.setUserId(user.getId());
		
		assertEquals("Failed to add the shipping address!", true, userDAO.addAddress(address));
		user = new User();
		user.setFirstName("Punkaj");
		user.setLastName("Singh");
		user.setEmail("ps@gmail.com");
		user.setContactNumber("1234567890");
		user.setRole("SUPPLIER");
		user.setPassword("pass");
		user.setEnabled(true);
		
		assertEquals("Error adding user",true,userDAO.addUser(user));
		
		user = new User();
		user.setFirstName("Niit");
		user.setLastName("Jadavpur");
		user.setEmail("niitjdv@gmail.com");
		user.setContactNumber("1234567890");
		user.setRole("ADMIN");
		user.setPassword("admin12345");
		user.setEnabled(true);
		assertEquals("Error adding user",true,userDAO.addUser(user));
	
	}
	

}
