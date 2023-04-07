package com.chim.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chim.biz.dao.CartDAO;
import com.chim.biz.dao.OrderDAO;
import com.chim.biz.dto.CartVO;
import com.chim.biz.dto.OrderVO;
import com.chim.biz.dto.ProductVO;

import utils.Criteria;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private ProductService productService;

	@Override
	public int selectMaxOseq() {

		return orderDAO.selectMaxOseq();
	}

	@Override
	public void insertOrder(OrderVO vo) {
		// TODO Auto-generated method stub
		orderDAO.insertOrder(vo);
	}

	@Override
	public int insertOrderDetail(OrderVO vo) {
		// TODO Auto-generated method stub

		int oseq = this.selectMaxOseq();
		vo.setOseq(oseq);

		this.insertOrder(vo);

		List<CartVO> cartList = cartDAO.selectCart(vo.getId());
		if (cartList.size() > 0) {
			for (CartVO cart : cartList) {
				OrderVO order = new OrderVO();
				ProductVO qty = new ProductVO();
				
				order.setOseq(oseq);
				order.setPseq(cart.getPseq());
				qty.setPseq(cart.getPseq());
				order.setQuantity(cart.getQuantity());
				qty.setQuantity(cart.getQuantity());
				
				orderDAO.insertOrderDetail(order);
				productService.updateQuantity(qty);
				cartDAO.updateCart(cart.getCseq());
				
			}
		} else {
			OrderVO order = new OrderVO();
			ProductVO qty = new ProductVO();
			
			order.setOseq(oseq);
			order.setPseq(vo.getPseq());
			qty.setPseq(vo.getPseq());
			order.setQuantity(vo.getQuantity());
			qty.setQuantity(vo.getQuantity());
			
			productService.updateQuantity(qty);
			orderDAO.insertOrderDetail(order);
		}
		return oseq;
	}

	@Override
	public List<OrderVO> listOrderById(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderDAO.listOrderById(vo);
	}

	@Override
	public void deleteOrder(int oseq) {
		// TODO Auto-generated method stub
		orderDAO.deleteOrder(oseq);
	}

	@Override
	public int countOrderListById(OrderVO vo) {
		// TODO Auto-generated method stub
		return orderDAO.countOrderListById(vo);
	}

	@Override
	public List<Integer> selectSeqOrdering(OrderVO vo, Criteria criteria) {
		// TODO Auto-generated method stub
		return orderDAO.selectSeqOrdering(vo,criteria);
	}

	@Override
	public List<OrderVO> getListOrder(String mname) {
		// TODO Auto-generated method stub
		return orderDAO.listOrder(mname);
	}

	@Override
	public void updateOrderResult(int odseq) {
		// TODO Auto-generated method stub
		orderDAO.updateOrderResult(odseq);
	}

}
