package com.niit.ECommerceBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Online_Category")
public class Category 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Category_Name")
	private String name;
	
	@Column(name="Description")
	private String desc;

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getDesc() 
	{
		return desc;
	}

	public void setDesc(String desc) 
	{
		this.desc = desc;
	}
	
	

}
