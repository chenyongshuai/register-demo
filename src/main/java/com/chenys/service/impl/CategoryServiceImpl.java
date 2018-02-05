package com.chenys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenys.dao.CategoryDao;
import com.chenys.entity.Category;
import com.chenys.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao dao;
	
	public List<Category> getCategoryByVirId(int virid) {
		return dao.getCategoryByVirId(virid);
	}

}
