package com.chim.view;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

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
	public String loginAction(MemberVO vo, Model model) {
		String pwd = memberService.confirmMember(vo.getId());

		if (pwd == null) {
			model.addAttribute("message", "아이디가 맞지 않습니다.");
			return "member/loginfail";
		} else if (!pwd.equals(vo.getPwd())) {
			model.addAttribute("message", "비밀번호가 맞지 않습니다.");
			return "member/loginfail";
		} else {
			model.addAttribute("loginUser", memberService.getMember(vo.getId()));
			return "redirect:index";
		}

	}

	@GetMapping("/logout")
	public String logoutAction(SessionStatus status) {

		status.setComplete();
		return "index";
	}

	@RequestMapping("/idCheck_form")
	public String idCheckForm(MemberVO vo, Model model) {

		String pwd = memberService.confirmMember(vo.getId());
		int message = 0;
		if (pwd == null) {// 아이디 사용 중 아님
			message = 0;

		} else {// 아이디 사용중
			message = 1;
		}
		model.addAttribute("id", vo.getId());
		model.addAttribute("message", message);
		return "member/idCheck";
	}

	@PostMapping("/join")
	public String joinAction(MemberVO vo, @RequestParam(value = "addressDetail") String addressDetail) {
		if (addressDetail != null) {
			vo.setAddress(vo.getAddress() + " " + addressDetail);
		}
		memberService.insertMember(vo);

		return "member/login";
	}

	@GetMapping("/find_id_form")
	public String findIdView() {

		return "member/findId";
	}

	@PostMapping("/find_id")
	public String findIdAction(MemberVO vo, Model model) {
		String id = memberService.getIdByNamePhone(vo);
		int message = 0;
		if (id == null) {
			message = -1;
		} else {
			message = 1;
		}
		model.addAttribute("id", id);
		model.addAttribute("message", message);
		return "member/findResult";
	}

	@GetMapping("/find_pwd_form")
	public String findPwdView() {

		return "member/findPwd";
	}

	@PostMapping("/find_pwd")
	public String findPwdAction(MemberVO vo, Model model) {
		String id = memberService.getIdByNamePhone(vo);
		int message = 0;

		if (id != null && id.equals(vo.getId())) {
			message = 1;
			model.addAttribute("id", vo.getId());
			model.addAttribute("message", message);
		} else {
			message = -1;
			model.addAttribute("message", message);
		}
		return "member/findPwdResult";
	}

	@PostMapping("/change_pwd")
	public String changePwdAction(MemberVO vo) {
		memberService.chagePwd(vo);

		return "member/changePwdOK";
	}
}
