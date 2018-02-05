package com.chenys.entity;

import java.util.List;

public class Category {
     
     private int categoryId;
	 private String categoryName;
	 private List<Category> categoryThird;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<Category> getCategoryThird() {
		return categoryThird;
	}
	public void setCategoryThird(List<Category> categoryThird) {
		this.categoryThird = categoryThird;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", categoryThird=" + categoryThird + "]";
	}
	 
	 
}
