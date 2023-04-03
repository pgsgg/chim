package com.chim.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chim.biz.dto.AdminVO;
import com.chim.biz.dto.ProductVO;
import com.chim.biz.service.AdminService;
import com.chim.biz.service.CartService;
import com.chim.biz.service.MemberService;
import com.chim.biz.service.ProductService;

import utils.Criteria;
import utils.PageMaker;

@Controller
@SessionAttributes("admin")
public class AdminController {

	
	@Autowired
	private ProductService productService;
	@Autowired
	private MemberService memberService;
	@Autowired
	private CartService cartService;
	@Autowired
	private AdminService adminService;

	// 메인화면 표시
	@RequestMapping("/admin_index")
	public String indexView() {
		return "admin/index";
	}

	// 에러화면 표시
	@RequestMapping("/admin_404")
	public String View404() {
		return "admin/404";
	}

	@RequestMapping("/admin_blank")
	public String blankView() {
		return "admin/blank";
	}

	@RequestMapping("/admin_buttons")
	public String buttonsView() {
		return "admin/buttons";
	}

	@RequestMapping("/admin_charts")
	public String chartsView() {
		return "admin/charts";
	}

	@RequestMapping("/admin_cards")
	public String cardsView() {
		return "admin/cards";
	}

	@RequestMapping("/admin_layout-static")
	public String layoutStaticView() {
		return "admin/layout-static";
	}

	@RequestMapping("/admin_login")
	public String loginView() {
		return "admin/login";
	}

	@RequestMapping("/admin_forgot-password")
	public String forgotPassword() {
		return "admin/forgot-password";
	}

	@RequestMapping("/admin_register")
	public String registerView() {
		return "admin/register";
	}

	@RequestMapping("/admin_tables")
	public String tablesView() {
		return "admin/tables";
	}

	@RequestMapping("/admin_utilities-animation")
	public String utilitiesAnimationView() {
		return "admin/utilities-animation";
	}

	@RequestMapping("/admin_utilities-border")
	public String utilitiesBorderView() {
		return "admin/utilities-border";
	}

	@RequestMapping("/admin_utilities-color")
	public String utilitiesColorView() {
		return "admin/utilities-color";
	}

	@RequestMapping("/admin_utilities-other")
	public String utilitiesOtherView() {
		return "admin/utilities-other";
	}

	@PostMapping("/admin_login")
	public String adminCheck(AdminVO vo, Model model) {

		int result = adminService.adminCheck(vo);

		if (result == 1) {
			model.addAttribute("admin", adminService.getAdmin(vo.getId()));
			return "";
		} else {

			if (result == 0) {
				model.addAttribute("message", "비밀번호를 확인해주세요.");
			} else {
				model.addAttribute("message", "아이디를 확인해주세요.");
			}
			return "admin/index";
		}

	}
	
	@RequestMapping("/admin_product_list")
	public String adminProductList( //productList.jsp 에 key를 param
			@RequestParam(value="pageNum", defaultValue="1") String pageNum, 
			@RequestParam(value="rowsPerPage", defaultValue="10") String rowsPerPage, 
			@RequestParam(value="key", defaultValue="") String name, 
			 Model model) {
		Criteria criteria= new Criteria();
		criteria.setPageNum(Integer.parseInt(pageNum));
		criteria.setRowsPerPage(Integer.parseInt(rowsPerPage));
		
		
		// (1) 전체 상품목록 조회
		List<ProductVO> productList = productService.getlistProductWithPaging(criteria, name);
		 
		// (2) 화면에 표시할 페이지 버튼 정보 설정(PageMaker 클래스 이용)
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria); // 현재 페이지 정보 저장
		pageMaker.setTotalCount(productService.countProductList(name)); // 전체 게시글의 수 저장
		
		// (2) model 객체에 상품 목록저장  --- productList.jsp 에 테이블이 productList 및 Size
		model.addAttribute("productList", productList);
		model.addAttribute("productListSize", productList.size());
		model.addAttribute("pageMaker", pageMaker);
		
		// (3) 화면 호출 : productList.jsp
		
		return "admin/product/productList";
		
	}

}
