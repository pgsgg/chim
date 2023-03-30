package com.chim.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chim.biz.dto.AdminVO;
import com.chim.biz.service.AdminService;
import com.chim.biz.service.CartService;
import com.chim.biz.service.MemberService;

@Controller
@SessionAttributes("admin")
public class AdminServiceController {
	
	/*
	 * @Autowired private ProductService productService;
	 */
	@Autowired
	private MemberService memberService;
	@Autowired
	private CartService cartService;
	@Autowired
	private AdminService adminService;
	
	
	//메인화면 표시
		@RequestMapping("/admin_index")
		public String indexView() {
			
			return "admin/index";
		}
	
		//에러화면 표시
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
		
		if(result ==1) {
			model.addAttribute("admin", adminService.getAdmin(vo.getId()));
			return "";
		} else {
			
			if(result==0) {
				model.addAttribute("message", "비밀번호를 확인해주세요.");
			} else {
				model.addAttribute("message", "아이디를 확인해주세요.");
			}
			return "admin/index";
		}
		
	}
	
	
	
	
	
}
