package com.niit.ECommerceFrontend.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		
		@RequestMapping(value = "/login")
		public ModelAndView login(@RequestParam(name="error", required = false)	String error,@RequestParam(name="logout", required = false)	String logout) 
		{
			ModelAndView mv = new ModelAndView("login");
		
			if(error!= null) 
			{
				mv.addObject("message", "Username and Password is invalid!");
			}
			if(logout!= null) 
			{
				mv.addObject("logout", "You have successfully logged out.");
			}
			
			mv.addObject("title","LOGIN");
			return mv;
		}
		
		@RequestMapping(value = "/access-denied")
		public ModelAndView accessDenied() 
		{
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("errorTitle", "!!! Caught You. !!!");		
			mv.addObject("errorDescription", "You are not authorized to view this page!");		
			mv.addObject("title", "403 Access Denied");	
			return mv;
		}
		
		@RequestMapping(value = "/custom-logout")
		public String logout(HttpServletRequest request, HttpServletResponse response)
		{
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
		    if (auth != null){    
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		    }
		    
		    return "redirect:/login?logout";
		}
}
