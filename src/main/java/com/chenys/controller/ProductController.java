package com.chenys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenys.entity.Product;
import com.chenys.service.ProductService;


@Controller
@RequestMapping("/product")
public class ProductController{
	
	@Autowired
	private ProductService service;
	
	@RequestMapping("/getProductById")
	public String getProductById(Integer virId,Integer secondId,Integer thirdId){
		
		List<Product>products = service.getProductByVirId(virId,secondId,thirdId);
		
		return "getProductById";
	}
	
	@RequestMapping("/getProductOrderByDisCount")
	public @ResponseBody List<Product> getProductOrderByDisCount(){
		
		return service.getProductOrderByDisCount();
	}
	
	@RequestMapping("/getProductByProId")
	public String getProductByProId(int proId){
		
		
		
		return null;
	}
}
