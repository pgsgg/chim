package com.chim.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chim.biz.dto.CartVO;
import com.chim.biz.dto.MemberVO;
import com.chim.biz.service.CartService;

@Controller
public class mypageController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping("cartList")
	public String cartList(HttpSession session,Model model) {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		List<CartVO> cart = cartService.getCart(loginUser.getId());
		int totalPrice = 0;
		for(CartVO c: cart) {
			totalPrice += c.getQuantity() * c.getPrice2();
		}
		model.addAttribute("cartList", cart);
		model.addAttribute("totalPrice", totalPrice);
		return "mypage/cartList";
	}
	
	@PostMapping("cart_delete")
	public String deleteCart(@RequestParam(value = "cseq") int[] cseq) {
		
		for(int i : cseq) {
			cartService.deleteCart(i);
		}
		
		return "redirect:cartList";
	}
}
