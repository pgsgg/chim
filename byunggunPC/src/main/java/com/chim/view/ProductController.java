package com.chim.view;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chim.biz.dto.ProductVO;
import com.chim.biz.service.ProductService;

import utils.Criteria;
import utils.PageMaker;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/product_detail", method = RequestMethod.GET)
	public String productDetailAction(ProductVO product, Model model) {

		// 상품상세조회
		ProductVO productVO = productService.selectProductDetail(product.getPseq());

		// JSP에 결과 조회
		model.addAttribute("productVO", productVO);

		// JSP 화면 호출
		return "product/productDetail";

	}

//	@GetMapping("/category")
//	public String productKindAction(ProductVO product,Model model) {
//		
//		// 상품상세조회
//		List<ProductVO> kindList=productService.getProductListByKind(product.getKind());
//		
//		// JSP에 결과 조회
//		model.addAttribute("productKindList",kindList);
//		
//		// JSP 화면 호출
//		return "product/productKind";
//		
//	}

	@RequestMapping("/category")
	public String productListByKindWithPagingAction(ProductVO product, Model model,
			@RequestParam(value = "pageNum", defaultValue = "1") String pageNum,
			@RequestParam(value = "rowsPerPage", defaultValue = "5") String rowsPerPage) {
		String[] kindList = { "CPU", "메인보드", "그래픽카드", "파워"};
		
		Criteria criteria = new Criteria();
		criteria.setPageNum(Integer.parseInt(pageNum));
		criteria.setRowsPerPage(Integer.parseInt(rowsPerPage));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(productService.countProductListByKind(product.getKind()));

		List<ProductVO> listProduct = productService.getProductListByKindWithPaging(product.getKind(), criteria);

		model.addAttribute("productKindList", listProduct);
		model.addAttribute("pageMaker",pageMaker);
		model.addAttribute("kindList", kindList);
		return "product/productKind";
	}
}
