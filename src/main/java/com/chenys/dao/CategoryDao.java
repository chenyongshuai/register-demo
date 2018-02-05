package com.chenys.dao;

import java.util.List;

import com.chenys.entity.Category;

public interface CategoryDao {
	
	public List<Category> getCategoryByVirId(int virid);
}
