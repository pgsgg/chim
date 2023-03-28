package com.chim.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.chim.biz.dto.MemberVO;
import com.chim.biz.service.MemberService;

@Controller
@SessionAttributes("loginUser")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/loginForm")
	public String loginForm() {
		
		return "member/login";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		
		return "member/join";
	}
	
	@PostMapping("/login")
	public String loginAction(MemberVO vo,Model model) {
		String pwd = memberService.confirmMember(vo.getId());
		
		if(pwd == null) {
			model.addAttribute("message", "아이디가 틀립니다.");
		} else if(pwd != vo.getPwd()) {
			model.addAttribute("message", "비밀번호가 틀립니다.");
		} else {
			model.addAttribute("loginUser", memberService.getMember(vo.getId()));
		}
		return "index";
	}
}
