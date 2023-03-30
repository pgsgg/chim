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
		@RequestMapping("/admin_main")
		public String mainView() {
			
			return "admin/main";
		}
	
		//에러화면 표시
		@RequestMapping("/admin_401")
		public String View401() {
			
			return "admin/401";
		}
		@RequestMapping("/admin_404")
		public String View404() {
			
			return "admin/404";
		}
		@RequestMapping("/admin_500")
		public String View500() {
			
			return "admin/500";
		}
		
		
		@RequestMapping("/admin_charts")
		public String chartsView() {
			
			return "admin/charts";
		}
		@RequestMapping("/admin_layout-sidenav-light")
		public String layoutSidenavLightView() {
			
			return "admin/layout-sidenav-light";
		}
		@RequestMapping("/admin_layout-static")
		public String layoutStaticView() {
			
			return "admin/layout-static";
		}
		@RequestMapping("/admin_login")
		public String loginView() {
			
			return "admin/login";
		}
		@RequestMapping("/admin_password")
		public String password() {
			
			return "admin/password";
		}
		@RequestMapping("/admin_register")
		public String registerView() {
			
			return "admin/register";
		}
		@RequestMapping("/admin_tables")
		public String tablesView() {
			
			return "admin/tables";
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
