package com.chim.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chim.biz.dto.AdminVO;
import com.chim.biz.dto.MemberVO;
import com.chim.biz.service.AdminService;
import com.chim.biz.service.CartService;
import com.chim.biz.service.MemberService;

@Controller
@SessionAttributes("admin")
public class AdminServiceController {
	
	@Autowired
	private MemberService memberService;
	@Autowired
	private CartService cartService;
	@Autowired
	private AdminService adminService;
	
	public String adminCheck(MemberVO vo, Model model) {
		
		String pwd = adminService.adminCheck(vo.getId());
		
		
		return "admin/index";
	}
	
	public String getAdmin(){
		
		/* List<AdminVO> adminList = new List<>(); */
				
				
		return "admin/index";
	}
	
}
