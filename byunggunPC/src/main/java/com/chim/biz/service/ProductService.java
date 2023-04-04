package com.chim.biz.service;

import java.util.List;

import com.chim.biz.dto.ProductVO;

import utils.Criteria;

public interface ProductService {

	List<ProductVO> selectProduct();
	
	ProductVO selectProductDetail(int pseq);
	
	List<ProductVO> getlistProductWithPaging(Criteria criteria,String name);
	
	int countProductList(String name);
		
	void updateQuantity(int quantity,int pseq);
	
	List<ProductVO> getProductListByKind (String kind);
	
	void insertProduct(ProductVO vo);
	
	void updateProduct(ProductVO vo);
	
	ProductVO getProduct(ProductVO vo);
	
}