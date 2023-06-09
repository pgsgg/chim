package com.chim.biz.service;

import java.util.List;

import com.chim.biz.dto.ProductVO;

import utils.Criteria;

public interface ProductService {

	List<ProductVO> selectProduct();

	ProductVO selectProductDetail(int pseq);

	List<ProductVO> getlistProductWithPaging(Criteria criteria, String name);

	int countProductList(String name);

	/*
	 * 상품 재고 관련 메소드
	 */
	void updateQuantity(ProductVO vo);

	void increaseQuantity(ProductVO vo);
	
	void updateSellable(ProductVO vo);
	
	int getProductQuantity(int pseq);
	/*
	 * 상품 재고 관련 메소드
	 */

	List<ProductVO> getProductListByKind(String kind);

	void insertProduct(ProductVO vo);

	void updateProduct(ProductVO vo);

	ProductVO getProduct(ProductVO vo);

	List<ProductVO> getProductListByKindWithPaging(String kind, Criteria criteria);

	int countProductListByKind(String kind);

	List<ProductVO> getProductListByBestynWithPaging(String bestyn, Criteria criteria);

	int countProductListByBestyn(String bestyn);

	List<ProductVO> searchProdcutList(String name, Criteria criteria);

	int countSearchProduct(String name);

	void deleteProduct(ProductVO vo);
}