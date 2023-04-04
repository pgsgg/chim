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
	public ProductVO getProduct(ProductVO product) {
		// TODO Auto-generated method stub
		return productDAO.getProduct(product);
	}
	@Override
	public ProductVO getProductDetail(int pseq) {
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
	public List<ProductVO> getListProduct(String name) {
		// TODO Auto-generated method stub
		return productDAO.listProduct(name);
	}
	@Override
	public void insertProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		productDAO.insertProduct(vo);
	}
	@Override
	public void updateProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		productDAO.updateProduct(vo);
	}
	@Override
	public List<ProductVO> getProductListByKind(String kind) {
		// TODO Auto-generated method stub
		return productDAO.getProductListByKind(kind);
	}
	@Override
	public List<ProductVO> getNewProductList() {
		// TODO Auto-generated method stub
		return productDAO.getNewProductList();
	}
	@Override
	public List<ProductVO> getBestProductList() {
		// TODO Auto-generated method stub
		return productDAO.getBestProductList();
	}
	/*
	 * @Override public ProductVO selectProduct() { // TODO Auto-generated method
	 * stub return productDAO.selectProduct(); }
	 */

}
