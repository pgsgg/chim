package com.chim.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chim.biz.dto.ProductVO;
import com.chim.biz.service.ProductService;

@Controller
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/product_detail")
	public String productDetail(ProductVO vo,Model model) {
		model.addAttribute("productVO", productService.selectProductDetail(vo.getPseq()));
		
		return "product/productDetail";
	}
}
