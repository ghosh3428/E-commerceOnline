package com.niit.ECommerceBackend.DAO;

import java.util.List;

import com.niit.ECommerceBackend.model.Address;
import com.niit.ECommerceBackend.model.User;

public interface UserDAO 
{
	boolean addUser(User user);
	
	boolean addAddress(Address address);
	
	User getByEmail(String email) ;
	
	Address getBillingAddress(int userId);
	
	List<Address> listShippingAddresses(int userId);
	
	Address getAddress(int addressId);
}