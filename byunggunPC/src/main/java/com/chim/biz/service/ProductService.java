package com.chim.biz.service;

import java.util.List;

import com.chim.biz.dto.ProductVO;

import utils.Criteria;

public interface ProductService {

	ProductVO getProduct(ProductVO product);

	List<ProductVO> getProductListByKind(String kind);

	List<ProductVO> getNewProductList();

	List<ProductVO> getBestProductList();

	//name == 조회할 상품명
	int countProductList(String name);

	List<ProductVO> getlistProduct(String name);

	List<ProductVO> getlistProductWithPaging(Criteria criteria, String name);

	void insertProduct(ProductVO vo);

	void updateProduct(ProductVO vo);

}