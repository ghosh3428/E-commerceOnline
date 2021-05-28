package com.niit.ECommerceBackend.DAO;

import java.util.List;

import com.niit.ECommerceBackend.model.Category;

public interface CategoryDAO 
{
		
	Category getCategory(int id);
	List<Category> categoryList();
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	boolean deleteCategory(Category category);

}
