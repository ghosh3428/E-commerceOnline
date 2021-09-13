package com.niit.ECommerceFrontend.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ECommerceBackend.DAO.CategoryDAO;
import com.niit.ECommerceBackend.DAO.ProductDAO;
import com.niit.ECommerceBackend.model.Category;
import com.niit.ECommerceBackend.model.Product;
import com.niit.ECommerceFrontend.Util.FileUpload;

import org.springframework.ui.Model;
@Controller
@RequestMapping(value="/manage")
public class ManageProductController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	
	@RequestMapping("/product")
	public ModelAndView manageProduct(@RequestParam(name="operation", required=false) String operation) 
	{		

		ModelAndView mv = new ModelAndView("page");	
		mv.addObject("title","Manage Product");		
		mv.addObject("userclickmanageproduct",true);
		
		Product product = new Product();
		
		mv.addObject("product" , product);
		
		if(operation != null) 
		{
			if(operation.equals("product"))
			{
				mv.addObject("message", "Product submitted successfully!");
			}
			else if(operation.equals("category"))
			{
				mv.addObject("message", "Category submitted successfully!");
			}
		}
		
		return mv;
		
	}
	
	@RequestMapping(value = "/add/product", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product newProduct ,BindingResult results,Model model , HttpServletRequest request)
	{
			if(results.hasErrors()) 
			{
		
				model.addAttribute("userclickmanageproduct",true);
				model.addAttribute("title","Product Management");
		 
				return "page";
			}
			newProduct.setSupplierId(2);
			productDAO.addProduct(newProduct);
			
			if(!newProduct.getFile().getOriginalFilename().equals("") )
			{
				FileUpload.uploadFile(request, newProduct.getFile(), newProduct.getCode()); 
			 }
						
			return "redirect:/manage/product?operation=product";
	}
	
	
	@ModelAttribute("categories") 
	public List<Category> modelCategories() 
	{
		return categoryDAO.categoryList();
	}
	

	@ModelAttribute("category") 
	public Category modelCategory() 
	{
		return new Category();
	}
	
	
	@RequestMapping(value = "/add/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute("category") Category newCategory)
	{
			categoryDAO.addCategory(newCategory);
			
		return "redirect:/manage/product?operation=category";
	}
	
	
	

}
