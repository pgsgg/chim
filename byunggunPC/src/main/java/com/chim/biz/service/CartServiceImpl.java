package com.chim.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chim.biz.dao.CartDAO;
import com.chim.biz.dto.CartVO;

@Service("cartService")
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDAO cartDAO;
	
	@Override
	public List<CartVO> getCart(String id) {
		// TODO Auto-generated method stub
		return cartDAO.selectCart(id);
	}

	@Override
	public void insertCart(CartVO vo) {
		// TODO Auto-generated method stub
		cartDAO.insertCart(vo);
	}

	@Override
	public void deleteCart(int cseq) {
		// TODO Auto-generated method stub
		cartDAO.deleteCart(cseq);
	}

	@Override
	public void updateCart(int cseq) {
		// TODO Auto-generated method stub
		cartDAO.updateCart(cseq);
	}

	@Override
	public int cartCounting(String id) {
		// TODO Auto-generated method stub
		return cartDAO.cartCounting(id);
	}

	@Override
	public void deleteProductInCart(int pseq) {
		// TODO Auto-generated method stub
		cartDAO.deleteProductInCart(pseq);
	}

}
