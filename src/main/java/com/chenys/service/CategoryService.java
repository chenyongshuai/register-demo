package com.chenys.service;

import java.util.List;

import com.chenys.entity.Category;


public interface CategoryService {
	public List<Category> getCategoryByVirId(int virid);
}
