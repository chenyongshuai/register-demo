package com.chenys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenys.dao.ProductDao;
import com.chenys.entity.Product;
import com.chenys.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;
	
	public List<Product> getProductByVirId(Integer virId, Integer secondId,
			Integer thirdId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getProductOrderByDisCount() {
		return dao.getProductOrderByDisCount();
	}

}
