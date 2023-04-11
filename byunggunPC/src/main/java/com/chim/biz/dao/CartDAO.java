package com.chim.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chim.biz.dto.CartVO;

@Repository
public class CartDAO{

	@Autowired
	private SqlSessionTemplate mybatis;

	public List<CartVO> selectCart(String id) {

		return mybatis.selectList("CartMapper.selectCart", id);
	}

	public void insertCart(CartVO vo) {
		mybatis.insert("CartMapper.insertCart", vo);
	}

	public void deleteCart(int cseq) {
		mybatis.delete("CartMapper.deleteCart", cseq);
	}

	public void updateCart(int cseq) {
		mybatis.update("CartMapper.updateCart", cseq);
	}
	
	public int cartCounting(String id) {
		return mybatis.selectOne("CartMapper.cartCounting", id);
	}
	public void deleteProductInCart(int pseq) {
		mybatis.delete("CartMapper.deleteProductInCart", pseq);
	}
}
