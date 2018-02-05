package com.chenys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chenys.entity.VirtualCategory;
import com.chenys.service.VirtualCategoryService;

@Controller
@RequestMapping("/virtualCategory")
public class VirtualCategoryController {
		
	@Autowired
	private VirtualCategoryService service;
	
	@RequestMapping("/getVirtualCategory")
	public @ResponseBody List<VirtualCategory> getVirtualCategory(){
		
		return service.getVirtualCategory();
		
	}
	
}
