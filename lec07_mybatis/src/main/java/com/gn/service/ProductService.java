package com.gn.service;

import java.util.List;

import com.gn.dao.ProductDao;
import com.gn.dto.Product;

public class ProductService {
	private ProductDao dao = new ProductDao();
	
	public List<Product> searchProduct(String productName, int productCategory, int sort) {
		Product param = new Product();
		param.setProductName(productName);
		param.setProductCategory(productCategory);
		param.setProductCategory(sort);
		
		List<Product> list = dao.searchProduct(param);
		return list;
	}

}
