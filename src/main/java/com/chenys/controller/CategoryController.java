package com.chenys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenys.entity.Category;
import com.chenys.service.CategoryService;


@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService service;
	
	@RequestMapping("/getCategoryByVirId")
	public @ResponseBody List<Category> getCategoryByVirId(int virtualCategoryId){
		
		return service.getCategoryByVirId(virtualCategoryId);
	}
	
	
	
}
