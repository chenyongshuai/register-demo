package com.chenys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenys.dao.VirtualCategoryDao;
import com.chenys.entity.VirtualCategory;
import com.chenys.service.VirtualCategoryService;

@Service
public class VirtualCategoryServiceImpl implements VirtualCategoryService {

	@Autowired
	private VirtualCategoryDao dao;
	
	public List<VirtualCategory> getVirtualCategory() {
		
		return dao.getVirtualCategory();
		
	}

}
