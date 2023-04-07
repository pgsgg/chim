package com.chim.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chim.biz.dto.CartVO;
import com.chim.biz.dto.MemberVO;
import com.chim.biz.dto.OrderVO;
import com.chim.biz.service.CartService;
import com.chim.biz.service.MemberService;
import com.chim.biz.service.OrderService;

@Controller
public class OrderControler {

	@Autowired
	private OrderService orderService;
	@Autowired
	private CartService cartService;
	@Autowired
	private MemberService memberService;

	@RequestMapping("/order_sheet")
	public String orderSheetView(OrderVO vo, HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			if (loginUser.getAddress() != null) {
				String fullAddress = loginUser.getAddress();
				String[] addressArr = fullAddress.split(" ");
				StringBuilder address = new StringBuilder();
				StringBuilder addressDetail = new StringBuilder();

				for (int i = 0; i < addressArr.length; i++) {
					if (i <= 3) {
						address.append(addressArr[i] + " ");
					} else {
						addressDetail.append(addressArr[i] + " ");
					}
				}
				address.deleteCharAt(address.length() - 1);
				model.addAttribute("address", address.toString());
				if (addressDetail.length()  > 0) {
					addressDetail.deleteCharAt(addressDetail.length() - 1);
					model.addAttribute("addressDetail", addressDetail.toString());
				}

			}
			List<CartVO> listOrder = cartService.getCart(loginUser.getId());
			int totalPrice = 0;
			if (listOrder.size() > 0) {
				for (CartVO cart : listOrder) {
					totalPrice += cart.getQuantity() * cart.getPrice2();
				}
			} else {
				totalPrice += vo.getQuantity() * vo.getPrice2();
			}
			model.addAttribute("order", vo);
			model.addAttribute("totalPrice", totalPrice);
			model.addAttribute("listOrder", listOrder);
			model.addAttribute("memberVO", loginUser);

			return "mypage/orderSheet";
		}
	}

	@RequestMapping("/insert_order")
	public String insertOrder(OrderVO vo, HttpSession session, Model model, MemberVO member,
			@RequestParam(value = "address") String address,
			@RequestParam(value = "addressDetail") String addressDetail) {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		if (loginUser == null) {
			return "member/login";
		} else {
			String fullAddress = address + " " + addressDetail;
			if (!loginUser.getName().equals(member.getName()) || !loginUser.getAddress().equals(fullAddress)
					|| !loginUser.getPhone().equals(member.getPhone())) {
				member.setId(loginUser.getId());
				member.setAddress(fullAddress);
				memberService.updateOrderSheet(member);
			}
			vo.setId(loginUser.getId());

			int oseq = orderService.insertOrderDetail(vo);
			model.addAttribute("oseq", oseq);
			return "redirect:order_list?result=1";
		}
	}

	// 주문 상세보기
	@RequestMapping("/order_list")
	public String listOrder(OrderVO vo, Model model, HttpSession session) {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		vo.setId(loginUser.getId());
		List<OrderVO> listOrder = orderService.listOrderById(vo);
		int totalPrice = 0;
		for (OrderVO order : listOrder) {
			totalPrice += order.getQuantity() * order.getPrice2();
		}

		model.addAttribute("listOrder", listOrder);
		model.addAttribute("totalPrice", totalPrice);
		return "mypage/orderList";
	}
}
