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
	private ProductDAO productDao;
	
	@Override
	public ProductVO getProduct(ProductVO product) {
		// TODO Auto-generated method stub
		return productDao.getProduct(product);
	}

	@Override
	public List<ProductVO> getProductListByKind(String kind) {
		// TODO Auto-generated method stub
		return productDao.getProductListByKind(kind);
	}

	@Override
	public List<ProductVO> getNewProductList() {
		// TODO Auto-generated method stub
		return productDao.getNewProductList();
	}

	@Override
	public List<ProductVO> getBestProductList() {
		// TODO Auto-generated method stub
		return productDao.getBestProductList();
	}

	@Override
	public int countProductList(String name) {
		// TODO Auto-generated method stub
		return productDao.countProductList(name);
	}

	@Override
	public List<ProductVO> getlistProduct(String name) {
		// TODO Auto-generated method stub
		return productDao.listProduct(name);
	}

	@Override
	public List<ProductVO> getlistProductWithPaging(Criteria criteria, String name) {
		// TODO Auto-generated method stub
		return productDao.listProductWithPaging(criteria, name);
	}

	@Override
	public void insertProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		productDao.insertProduct(vo);
	}

	@Override
	public void updateProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		productDao.updateProduct(vo);
	}

}
