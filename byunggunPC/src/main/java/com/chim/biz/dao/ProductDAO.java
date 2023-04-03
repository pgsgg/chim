package com.chim.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chim.biz.dto.ProductVO;

@Repository
public class ProductDAO {

	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<ProductVO> selectProduct(){
		
		return mybatis.selectList("ProductMapper.selectProduct");
	}
	
	public ProductVO selectProductDetail(int pseq) {
		
		return mybatis.selectOne("ProductMapper.selectProductDetail", pseq);
	}
}
