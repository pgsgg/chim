package com.chim.view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.NestedServletException;

import com.chim.biz.dto.AdminVO;
import com.chim.biz.dto.MemberVO;
import com.chim.biz.dto.OrderVO;
import com.chim.biz.dto.ProductVO;
import com.chim.biz.dto.QnaVO;
import com.chim.biz.service.AdminService;
import com.chim.biz.service.CartService;
import com.chim.biz.service.CommentService;
import com.chim.biz.service.MemberService;
import com.chim.biz.service.OrderService;
import com.chim.biz.service.ProductService;
import com.chim.biz.service.QnaService;

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
	@Autowired
	private QnaService qnaService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private OrderService orderService;

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


	@RequestMapping("/admin_forgot-password")
	public String forgotPassword() {
		return "admin/forgot-password";
	}

	@RequestMapping("/admin_register")
	public String registerView() {
		return "admin/register";
	}

	@RequestMapping("/admin_tables")
	public String tablesView(Criteria criteria, @RequestParam(value = "key", defaultValue = "") String name,
			Model model) {
		List<ProductVO> productList = productService.getlistProductWithPaging(criteria, name);
		String[] kindList = { "CPU", "메인보드", "그래픽카드", "파워", "조립 PC", "세일상품" };
		Map<String, String> kind = new HashMap<String, String>();
		for (int i = 0; i < kindList.length; i++) {
			kind.put(Integer.toString(i+1), kindList[i]);
		}
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(productService.countProductList(name));

		model.addAttribute("productList", productList);
		model.addAttribute("productListSize", productList.size());
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("kind", kind);

		return "admin/product/productList";
	}

	@RequestMapping("/admin_tables2")
	public String tables2View() {
		return "admin/product/productList2";
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

	@RequestMapping("admin_logout")
	public String adminLogout(SessionStatus status) {
		status.setComplete();

		return "admin/main";
	}

	@RequestMapping("/admin_product_list")
	public String adminProductList( // productList.jsp 에 key를 param
			@RequestParam(value = "pageNum", defaultValue = "1") String pageNum,
			@RequestParam(value = "rowsPerPage", defaultValue = "10") String rowsPerPage,
			@RequestParam(value = "key", defaultValue = "") String name, Model model) {
		String[] kindList = { "CPU", "메인보드", "그래픽카드", "파워", "조립 PC", "세일상품" };
		Map<String, String> kind = new HashMap<String, String>();
		Criteria criteria = new Criteria();
		criteria.setPageNum(Integer.parseInt(pageNum));
		criteria.setRowsPerPage(Integer.parseInt(rowsPerPage));

		// (1) 전체 상품목록 조회
		List<ProductVO> productList = productService.getlistProductWithPaging(criteria, name);

		// (2) 화면에 표시할 페이지 버튼 정보 설정(PageMaker 클래스 이용)
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria); // 현재 페이지 정보 저장
		pageMaker.setTotalCount(productService.countProductList(name)); // 전체 게시글의 수 저장
		
		for (int i = 0; i < kindList.length; i++) {
			kind.put(Integer.toString(i+1), kindList[i]);
		}
		// (2) model 객체에 상품 목록저장 --- productList.jsp 에 테이블이 productList 및 Size
		model.addAttribute("productList", productList);
		model.addAttribute("productListSize", productList.size());
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("kind", kind);
		
		// (3) 화면 호출 : productList.jsp

		return "admin/product/productList";

	}

	@RequestMapping("/admin_product_write_form")
	public String adminProductWriteView(Model model) {
		String[] kindList = { "CPU", "메인보드", "그래픽카드", "파워", "조립 PC", "세일상품" };
		model.addAttribute("kindList", kindList);
		return "admin/product/productWrite";
	}

	// 상품 등록처리
	@RequestMapping("/admin_product_write")
	public String adminProductWrite(ProductVO vo, HttpSession session,
			@RequestParam(value = "product_image",required = false) MultipartFile uploadFile) {

		if (!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			vo.setImage(fileName); // 테이블에 파일명 저장 용도

			// 전송된 이미지 파일을 이동할 실제 경로 구하기 -- ServletContext 는 webapp 까지 .. 이후는 지정
			String image_path = session.getServletContext().getRealPath("WEB-INF/resources/images/product/");
			try {
				uploadFile.transferTo(new File(image_path + fileName));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		productService.insertProduct(vo);
		return "redirect:admin_product_list";
	}

	@RequestMapping("/admin_product_detail")
	public String adminProductDetailAction(ProductVO vo, Model model) {
		String[] kindList = { "", "CPU", "메인보드", "그래픽카드", "파워", "조립 PC", "세일상품" };
		ProductVO product = productService.getProduct(vo);
		model.addAttribute("productVO", product);// productDetail에 사용된 productVO 보고 작성.
		int index = Integer.parseInt(product.getKind());
		model.addAttribute("kind", kindList[index]);

		return "admin/product/productDetail";
	}

	@RequestMapping("/admin_product_update_form")
	public String adminProductUpdateView(ProductVO vo, Model model) {
		String[] kindlist = { "CPU", "메인보드", "그래픽카드", "파워", "조립 PC", "세일상품" };

		ProductVO product = productService.getProduct(vo);
		model.addAttribute("productVO", product);
		model.addAttribute("kindList", kindlist);
		return "admin/product/productUpdate";
	}

	@RequestMapping("/admin_product_update")
	public String adminProductUpdate(ProductVO vo, @RequestParam(value = "product_image") MultipartFile uploadFile,
			@RequestParam(value = "nonmakeImg") String org_image, HttpSession session) {

		if (!uploadFile.isEmpty()) { // 상품 이미지를 수정한 경우임.
			String fileName = uploadFile.getOriginalFilename();
			vo.setImage(fileName); // 테이블에 파일명 저장 용도

			// 전송된 이미지 파일을 이동할 실제 경로 구하기 -- ServletContext 는 webapp 까지 .. 이후는 지정
			String image_path = session.getServletContext().getRealPath("WEB-INF/resources/images/product/");
			try {
				uploadFile.transferTo(new File(image_path + fileName));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		} else { // 상품의 기존 이미지 사용
			vo.setImage(org_image);
		}
		// 베스트 상품, 신규 상품 처리
//		if (vo.getUseyn() == null) {
//			vo.setUseyn("n");
//		} else {
//			vo.setUseyn("y");
//		}

		if (vo.getBestyn() == null) {
			vo.setBestyn("n");
		} else {
			vo.setBestyn("y");
		}
		productService.updateProduct(vo);
		return "redirect:admin_product_list";
	}

	@RequestMapping("/admin_member_list")
	public String memberList(@RequestParam(value = "key", defaultValue = "") String name, Model model) {
		List<MemberVO> memberList = memberService.getListMember(name);
		model.addAttribute("memberList", memberList);

		return "admin/member/memberList";
	}

	@RequestMapping("/admin_login_form")
	public String adminLoginView(HttpSession session) {

		return "admin/main";
	}

	@RequestMapping("/admin_login")
	public String adminLogin(AdminVO vo, Model model) {
		// (1) 관리자 ID 인증
		int result = adminService.adminCheck(vo);

		// (2) 정상적인 관리자이면
		// - 관리자 정보 조회
		// - 상품목록 화면으로 이동
		if (result == 1) {
			model.addAttribute("admin", adminService.getAdmin(vo.getId()));
			return "redirect:admin_product_list";
		} else {
			// (3) 비정상적인 로그인 일때
			// - 메시지를 설정하고 로그인화면으로 이동
			if (result == 0) {
				model.addAttribute("message", "비밀번호를 확인해주세요.");
			} else {
				model.addAttribute("message", "아이디를 확인해주세요.");
			}
			return "admin/main";
		}

	}

	@RequestMapping("/admin_join")
	public String joinAction(AdminVO vo) {
		adminService.insertAdmin(vo);

		return "redirect:admin_login";
	}
	
	@RequestMapping("/admin_qna_list")
	public String adminQnaList(Model model) {
		List<QnaVO> qnaList= qnaService.getListAllQna();
		
		model.addAttribute("qnaList", qnaList);
		
		return "admin/qna/qnaList";
	}
	
	@PostMapping("/admin_qna_detail")
	public String adminQnaDetail(QnaVO vo, Model model) {
		QnaVO qna = qnaService.getQna(vo.getQseq());
		model.addAttribute("qnaVO", qna);
		
		return "admin/qna/qnaDetail";
	}
	
	@PostMapping("/admin_qna_repsave")
	public String adminQnaRepSave(QnaVO vo) {
		
		qnaService.updateQna(vo);
		
		return "redirect:admin_qna_list";
	}
	
	@RequestMapping("/admin_order_list")
	public String adminOrderList(@RequestParam(value="key",defaultValue="") String mname,
			Model model) {
		
		List<OrderVO> orderList = orderService.getListOrder(mname);
		model.addAttribute("orderList", orderList);
		
		return "admin/order/orderList";
	}
	
	//주문완료 처리
	@RequestMapping("/admin_order_save")
	public String adminOrderSave(@RequestParam(value="result") int[] odseq) {
		
		for(int i=0;i<odseq.length;i++) {
			orderService.updateOrderResult(odseq[i]);
		}
		
		return "redirect:admin_order_list";
	}
	
	@RequestMapping("/admin_delete_product")
	public String deleteBoard(ProductVO vo) {
		try {
			cartService.deleteProductInCart(vo.getPseq());
			productService.deleteProduct(vo);
			return "redirect:/admin_product_list";
		} catch (Exception e) {
			return "redirect:admin_delete_fail";
		}
		
	}
	@RequestMapping("/admin_delete_fail")
	public String deleteFailed() {
		
		return "admin/product/deleteProductFailed";
	}

}
