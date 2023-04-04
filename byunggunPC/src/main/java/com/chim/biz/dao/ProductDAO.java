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
	
	/*
	 * public ProductVO selectProduct(){
	 * 
	 * return mybatis.selectOne("ProductMapper.selectProduct"); }
	 */
	
	public ProductVO getProduct(ProductVO product){
		
		return mybatis.selectOne("ProductMapper.selectProduct",product);
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
	
public List<ProductVO> getProductListByKind(String kind) {
		
		return mybatis.selectList("ProductMapper.getProductListByKind", kind);
	}
	

	public List<ProductVO> getNewProductList() {
		
		return mybatis.selectList("ProductMapper.getNewProductList");
	}
	public List<ProductVO> getBestProductList() {
		
		return mybatis.selectList("ProductMapper.getBestProductList");
	}
	
		public List<ProductVO> listProduct(String name) {
			return mybatis.selectList("ProductMapper.listProduct", name);
		}
		
		public List<ProductVO> listProductWithPaging(Criteria criteria, String name) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("criteria", criteria);
			map.put("name", name);
			
			return mybatis.selectList("ProductMapper.listProductWithPaging", map);
		}
		
		public void insertProduct(ProductVO vo) {
			
			mybatis.insert("ProductMapper.insertProduct", vo);
		}
		
		public void updateProduct(ProductVO vo) {
			mybatis.update("ProductMapper.updateProduct", vo);
		}
}
