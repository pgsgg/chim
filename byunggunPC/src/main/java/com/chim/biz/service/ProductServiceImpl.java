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
		return productDAO.getlistProductWithPaging(criteria, name);
	}

	@Override
	public int countProductList(String name) {
		// TODO Auto-generated method stub
		return productDAO.countProductList(name);
	}

	/*
	 * 상품 재고 관련 메소드
	 */
	@Override
	public void updateQuantity(ProductVO vo) {
		// TODO Auto-generated method stub
		productDAO.updateQuantity(vo);
		
		if(productDAO.getProductQuantity(vo.getPseq()) == 0) {
			vo.setSellable(0);
			productDAO.updateSellable(vo);
		}
	}
	@Override
	public void increaseQuantity(ProductVO vo) {
		// TODO Auto-generated method stub
		productDAO.increaseQuantity(vo);
		
		if(productDAO.getProductQuantity(vo.getPseq()) > 0) {
			vo.setSellable(1);
			productDAO.updateSellable(vo);
		}
	}
	
	@Override
	public void updateSellable(ProductVO vo) {
		// TODO Auto-generated method stub
		productDAO.updateSellable(vo);
	}
	
	@Override
	public int getProductQuantity(int pseq) {
		// TODO Auto-generated method stub
		return productDAO.getProductQuantity(pseq);
	}

	/*
	 * 상품 재고 관련 메소드 끝
	 */
	@Override
	public List<ProductVO> getProductListByKind(String kind) {
		// TODO Auto-generated method stub
		return productDAO.getProductListByKind(kind);
	}

	@Override
	public List<ProductVO> getProductListByKindWithPaging(String kind, Criteria criteria) {
		// TODO Auto-generated method stub
		return productDAO.getProductListByKindWithPaging(kind, criteria);
	}

	@Override
	public int countProductListByKind(String kind) {
		// TODO Auto-generated method stub
		return productDAO.countProductListByKind(kind);
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
		if(vo.getQuantity() > 0) {
			vo.setSellable(1);
			productDAO.updateSellable(vo);
		} else {
			vo.setSellable(0);
			productDAO.updateSellable(vo);
		}
	}

	@Override
	public ProductVO getProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		return productDAO.getProduct(vo);
	}

	@Override
	public void deleteProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		productDAO.deleteProduct(vo);
	}

	@Override
	public List<ProductVO> searchProdcutList(String name, Criteria criteria) {
		// TODO Auto-generated method stub
		return productDAO.searchProdcutList(name, criteria);
	}

	@Override
	public int countSearchProduct(String name) {
		// TODO Auto-generated method stub
		return productDAO.countSearchProduct(name);
	}

	@Override
	public List<ProductVO> getProductListByBestynWithPaging(String bestyn, Criteria criteria) {
		// TODO Auto-generated method stub
		return productDAO.getProductListByBestynWithPaging(bestyn, criteria);
	}

	@Override
	public int countProductListByBestyn(String bestyn) {
		// TODO Auto-generated method stub
		return productDAO.countProductListByBestyn(bestyn);
	}



}
