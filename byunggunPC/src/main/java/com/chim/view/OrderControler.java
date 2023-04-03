package com.chim.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chim.biz.dto.MemberVO;
import com.chim.biz.dto.OrderVO;
import com.chim.biz.service.OrderService;

@Controller
public class OrderControler {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/insert_order")
	public String insertOrder(OrderVO vo,HttpSession session,Model model) {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			return "member/login";
		} else {
			vo.setId(loginUser.getId());
			
			int oseq = orderService.insertOrderDetail(vo);
			model.addAttribute("oseq", oseq);
			return "redirect:order_list";
		}
	}
	
	@RequestMapping("/order_list")
	public String listOrder(OrderVO vo,Model model,HttpSession session) {
		MemberVO loginUser =  (MemberVO) session.getAttribute("loginUser");
		vo.setId(loginUser.getId());
		vo.setResult("1");
		List<OrderVO> listOrder = orderService.listOrderById(vo);
		int totalPrice = 0;
		for(OrderVO order : listOrder) {
			totalPrice += order.getQuantity()*order.getPrice2();
		}
		
		model.addAttribute("listOrder", listOrder);
		model.addAttribute("totalPrice", totalPrice);
		return "mypage/orderList";
	}
}
