package com.chenys.dao;

import java.util.List;

import com.chenys.entity.Product;


public interface ProductDao {

	List<Product> getProductOrderByDisCount();

}
