package com.niit.ECommerceFrontend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ECommerceBackend.DAO.CategoryDAO;

@Controller
public class PageController 
{
		@Autowired
		private CategoryDAO categoryDAO;
		
		@RequestMapping(value={"/","/index","/home"})
		public ModelAndView index()
		{
			ModelAndView mv = new ModelAndView("page");
			
			mv.addObject("categoryList" , categoryDAO.categoryList());
			mv.addObject("title", "E-Commerce Online");
			mv.addObject("userclickhome" , true);
			
			return mv;
		}
		
		@RequestMapping(value= "/about")
		public ModelAndView aboutUs()
		{
			ModelAndView mv = new ModelAndView("page");
			
			mv.addObject("title", "About Us");
			mv.addObject("userclickabout" , true);
			return mv;
		}
		
		@RequestMapping(value= "/contact")
		public ModelAndView contactUs()
		{
			ModelAndView mv = new ModelAndView("page");
			
			mv.addObject("title", "Contact Us");
			mv.addObject("userclickcontact" , true);
			return mv;
		}
		
		@RequestMapping(value= "/show/all/products")
		public ModelAndView allProducts()
		{
			ModelAndView mv = new ModelAndView("page");
			
			mv.addObject("categoryList" , categoryDAO.categoryList());
			mv.addObject("title", "All Product");
			mv.addObject("userclickallproduct" , true);
			return mv;
		}
		
		@RequestMapping(value= "/show/category/{id}/products")
		public ModelAndView categoryProducts(@PathVariable("id") int id)
		{
			ModelAndView mv = new ModelAndView("page");
			
			mv.addObject("category" , categoryDAO.getCategory(id));
			mv.addObject("categoryList" , categoryDAO.categoryList());
			mv.addObject("title", "Category Product");
			mv.addObject("userclickcategoryproduct" , true);
			return mv;
		}
}
