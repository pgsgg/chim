package com.chim.biz.service;

import java.util.List;

import com.chim.biz.dto.CartVO;

public interface CartService {

	List<CartVO> getCart(String id);

	void insertCart(CartVO vo);

	void deleteCart(int cseq);

	void updateCart(int cseq);
	
	int cartCounting(String id);
	
	void deleteProductInCart(int pseq);
}