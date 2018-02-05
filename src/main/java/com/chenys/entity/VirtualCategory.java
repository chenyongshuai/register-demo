package com.chenys.entity;

import java.util.List;

public class VirtualCategory {
	private int virtualCategoryId;
    private String virtualCategoryName;
	private List<Category>categorySecond;
	public int getVirtualCategoryId() {
		return virtualCategoryId;
	}
	public void setVirtualCategoryId(int virtualCategoryId) {
		this.virtualCategoryId = virtualCategoryId;
	}
	public String getVirtualCategoryName() {
		return virtualCategoryName;
	}
	public void setVirtualCategoryName(String virtualCategoryName) {
		this.virtualCategoryName = virtualCategoryName;
	}
	public List<Category> getCategorySecond() {
		return categorySecond;
	}
	public void setCategorySecond(List<Category> categorySecond) {
		this.categorySecond = categorySecond;
	}
	@Override
	public String toString() {
		return "VirtualCategory [virtualCategoryId=" + virtualCategoryId
				+ ", virtualCategoryName=" + virtualCategoryName
				+ ", categorySecond=" + categorySecond + "]";
	}
	
	
}
