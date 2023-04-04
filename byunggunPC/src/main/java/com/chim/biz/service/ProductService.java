package com.chim.biz.service;

import java.util.List;

import com.chim.biz.dto.ProductVO;

import utils.Criteria;

public interface ProductService {

	/* ProductVO selectProduct(); */
	
	ProductVO getProduct(ProductVO product);
	
	ProductVO getProductDetail(int pseq);
	
	List<ProductVO> getlistProductWithPaging(Criteria criteria,String name);
	
	int countProductList(String name);
		
	List<ProductVO> getListProduct(String name);
	
	void insertProduct(ProductVO vo);
	
	void updateProduct(ProductVO vo);
	
	List<ProductVO> getProductListByKind(String kind);

	List<ProductVO> getNewProductList();

	List<ProductVO> getBestProductList();
}