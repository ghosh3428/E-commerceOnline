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
}
