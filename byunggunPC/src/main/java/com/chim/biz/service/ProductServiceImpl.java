package com.chim.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chim.biz.dao.ProductDAO;
import com.chim.biz.dto.ProductVO;

import utils.Criteria;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	@Override
	public List<ProductVO> selectProduct() {
		// TODO Auto-generated method stub
		return productDAO.selectProduct();
	}
	@Override
	public ProductVO selectProductDetail(int pseq) {
		// TODO Auto-generated method stub
		return productDAO.selectProductDetail(pseq);
	}
	@Override
	public List<ProductVO> getlistProductWithPaging(Criteria criteria, String name) {
		// TODO Auto-generated method stub
		return productDAO.getlistProductWithPaging(criteria,name);
	}
	@Override
	public int countProductList(String name) {
		// TODO Auto-generated method stub
		return productDAO.countProductList(name);
	}
	@Override
	public void updateQuantity(int quantity,int pseq) {
		// TODO Auto-generated method stub
		productDAO.updateQuantity(quantity,pseq);
	}
	@Override
	public List<ProductVO> getProductListByKind(String kind) {
		// TODO Auto-generated method stub
		return productDAO.getProductListByKind(kind);
	}
	

}
