package com.chim.biz.service;

import java.util.List;

import com.chim.biz.dto.ProductVO;

public interface ProductService {

	List<ProductVO> selectProduct();
	
	ProductVO selectProductDetail(int pseq);
}