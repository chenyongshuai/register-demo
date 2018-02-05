package com.chenys.service;

import java.util.List;

import com.chenys.entity.Product;


public interface ProductService {

	List<Product> getProductByVirId(Integer virId, Integer secondId,
			Integer thirdId);

	List<Product> getProductOrderByDisCount();

}
