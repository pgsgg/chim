package com.chim.biz.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chim.biz.dto.ProductVO;

import utils.Criteria;

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
	
	public List<ProductVO> getlistProductWithPaging(Criteria criteria, String name) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("criteria", criteria);
		map.put("name", name);
		return mybatis.selectList("ProductMapper.listProductWithPaging",map);
	}
	
	public int countProductList(String name){
		
		return mybatis.selectOne("ProductMapper.countProductList",name);
	}
	
	
//	<select id="countProductList" parameterType="String" resultType="int">
//	getlistProductWithPaging
//	countProductList
//	<!-- 상품목록 조회 -->
//	<select id="listProduct" parameterType="String" resultType="product">
//
//	<!-- 페이지별 상품 목록 조회 -->
//	<select id="listProductWithPaging" resultType="product">
	
}
