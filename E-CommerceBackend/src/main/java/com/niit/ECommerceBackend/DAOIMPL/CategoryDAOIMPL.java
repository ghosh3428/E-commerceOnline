package com.niit.ECommerceBackend.DAOIMPL;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ECommerceBackend.DAO.CategoryDAO;
import com.niit.ECommerceBackend.model.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOIMPL implements CategoryDAO 
{

	@Autowired
	SessionFactory sessionFactory;//bean will search for getSessionFactory()
	
	@Override
	public boolean addCategory(Category category) 
	{
		try
		{
			category.setActive(true);
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Category getCategory(int id) 
	{
		return sessionFactory.getCurrentSession().get(Category.class,id );
		
	}

	@Override
	public List<Category> categoryList() 
	{
		String selectActiveCategory = "FROM Category WHERE isActive = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();

	}

	@Override
	public boolean deleteCategory(Category category) 
	{
		try
		{
			category.setActive(false);
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

}
