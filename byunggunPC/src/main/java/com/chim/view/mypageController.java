package com.chim.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.expression.MapAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.chim.biz.dto.CartVO;
import com.chim.biz.dto.MemberVO;
import com.chim.biz.dto.OrderVO;
import com.chim.biz.dto.ProductVO;
import com.chim.biz.service.CartService;
import com.chim.biz.service.MemberService;
import com.chim.biz.service.OrderService;
import com.chim.biz.service.ProductService;

import utils.Criteria;
import utils.PageMaker;

@Controller
public class mypageController {

	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderSerive;
	@Autowired
	private ProductService productService;
	/*
	 * @GetMapping("/mypage") public String mypageView() {
	 * 
	 * return "mypage/mypage"; }
	 */

	@RequestMapping("cartList")
	public String cartList(HttpSession session, Model model) {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		List<CartVO> cart = cartService.getCart(loginUser.getId());
		int totalPrice = 0;
		for (CartVO c : cart) {
			totalPrice += c.getQuantity() * c.getPrice2();
		}
		model.addAttribute("cartList", cart);
		model.addAttribute("totalPrice", totalPrice);
		return "mypage/cartList";
	}

	@PostMapping("cart_delete")
	public String deleteCart(@RequestParam(value = "cseq") int[] cseq) {

		for (int i : cseq) {
			cartService.deleteCart(i);
		}

		return "redirect:cartList";
	}

	@PostMapping("cart_insert")
	public String insertCart(HttpSession session, CartVO vo) {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");

		if (loginUser == null) {
			return "redirect:loginForm";
		} else {
			vo.setId(loginUser.getId());
			cartService.insertCart(vo);
			return "redirect:cartList";

		}
	}

	@RequestMapping("/orders")
	public String mypageAction(HttpSession session, Model model, OrderVO vo,
			@RequestParam(value = "result") String result,
			@RequestParam(value = "pageNum", defaultValue = "1") String pageNum,
			@RequestParam(value = "rowsPerPage", defaultValue = "5") String rowsPerPage) {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if (loginUser == null) {

			return "member/login";
		} else {
			vo.setId(loginUser.getId());
			vo.setResult(result);
			String title = null;

			Criteria criteria = new Criteria();
			criteria.setPageNum(Integer.parseInt(pageNum));
			criteria.setRowsPerPage(Integer.parseInt(rowsPerPage));

			PageMaker pageMaker = new PageMaker();
			pageMaker.setCriteria(criteria);
			pageMaker.setTotalCount(orderSerive.countOrderListById(vo));

			if (result.equals("1")) {
				title = "입금확인중";
			} else if (result.equals("2")) {
				title = "결제완료";
			} else {
				title = "";
			}
			List<Integer> listOseq = orderSerive.selectSeqOrdering(vo, criteria);
			List<OrderVO> summaryList = new ArrayList<OrderVO>();

			for (int oseq : listOseq) {
				OrderVO order = new OrderVO();
				order.setOseq(oseq);
				order.setId(loginUser.getId());
				order.setResult(result);

				List<OrderVO> list = orderSerive.listOrderById(order);
				OrderVO summary = list.get(0);
				if (list.size() >= 2) {
					summary.setPname(summary.getPname() + " 외 " + (list.size() - 1) + "개");
				} else {
					summary.setPname(summary.getPname());
				}
				int totalPrice = 0;
				for (OrderVO sumPrice : list) {
					totalPrice += sumPrice.getQuantity() * sumPrice.getPrice2();
				}
				summary.setPrice2(totalPrice);

				summaryList.add(summary);
			}

			model.addAttribute("orderList", summaryList);
			model.addAttribute("title", title);
			model.addAttribute("pageMaker", pageMaker);
			return "mypage/mypage";
		}

	}
	
	@RequestMapping("/order_delete")
	public String deleteOrderAction(@RequestParam(value = "oseq") int[] oseq,HttpSession session,
			RedirectAttributes redirect) {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		OrderVO ovo = new OrderVO();
		ovo.setResult("1");
		ovo.setId(loginUser.getId());
		ArrayList<ProductVO> pseq = new ArrayList<>();
		for(int i = 0;i<oseq.length; i++) {
			ovo.setOseq(oseq[i]);
			List<OrderVO> list = orderSerive.listOrderById(ovo);
			for(OrderVO  order : list) {
				ProductVO vo = new ProductVO();
				vo.setPseq(order.getPseq());
				vo.setQuantity(order.getQuantity());
				pseq.add(vo);
			}		
		}
		for(int i : oseq) {
			orderSerive.deleteOrder(i);
			ovo.setOseq(i);
		}
		redirect.addFlashAttribute("pseq", pseq);
		return "redirect:increaseQuantity";
	}
	
	@RequestMapping("/increaseQuantity")
	public String increaserQuantityAction(HttpServletRequest request,ModelMap map) {
		Map<String, ?> redirectMap = RequestContextUtils.getInputFlashMap(request);
		ArrayList<ProductVO> pseq = (ArrayList<ProductVO>) redirectMap.get("pseq");
		for(ProductVO product : pseq) {
			productService.increaseQuantity(product);
		}
		
		return "redirect:orders?result=1";
	}
	@ResponseBody
	@RequestMapping("/cart_counting")
	public int cartCounting(HttpSession session) {

		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		if (loginUser == null) {
			return 0;
		} else {
			int counting = cartService.cartCounting(loginUser.getId());
			return counting;
		}
	}
}
