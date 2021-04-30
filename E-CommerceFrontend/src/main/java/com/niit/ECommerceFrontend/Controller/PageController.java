package com.niit.ECommerceFrontend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController 
{

		@RequestMapping(value={"/","/index","/home"})
		public ModelAndView index()
		{
			ModelAndView mv = new ModelAndView("page");
			
			mv.addObject("title", "E-Commerce Online");
			
			return mv;
		}
		
		@RequestMapping(value= "/about")
		public ModelAndView aboutUs()
		{
			ModelAndView mv = new ModelAndView("aboutus");
			
			mv.addObject("title", "About Us");
			
			return mv;
		}
}
