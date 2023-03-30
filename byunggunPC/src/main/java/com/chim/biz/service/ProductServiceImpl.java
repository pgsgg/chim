package com.chim.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chim.biz.dao.ProductDAO;
import com.chim.biz.dto.ProductVO;

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

}
