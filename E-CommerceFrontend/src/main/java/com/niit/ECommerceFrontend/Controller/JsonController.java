package com.niit.ECommerceFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.ECommerceBackend.DAO.ProductDAO;
import com.niit.ECommerceBackend.model.Product;

@Controller
@RequestMapping("/json/show")
public class JsonController {

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllActiveProducts() 
	{
		return productDAO.listActiveProducts();
	}

	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id) 
	{
		return productDAO.listActiveProductsByCategory(id);
	}
	
	
	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getProducts() 
	{
		return productDAO.productList();
	}
}