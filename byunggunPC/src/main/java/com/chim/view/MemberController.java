package com.chim.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
	
	@GetMapping("/login")
	public String loginForm() {
		
		return "member/login";
	}
	
	@GetMapping("/join")
	public String joinForm() {
		
		return "member/join";
	}
}
