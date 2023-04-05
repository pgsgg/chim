package com.chim.biz.service;

import java.util.List;

import com.chim.biz.dto.OrderVO;

import utils.Criteria;

public interface OrderService {

	int selectMaxOseq();

	void insertOrder(OrderVO vo);

	int insertOrderDetail(OrderVO vo);

	List<OrderVO> listOrderById(OrderVO vo);
	
	 List<Integer> selectSeqOrdering(OrderVO vo,Criteria criteria);
	
	 void deleteOrder(int oseq);
	
	int countOrderListById(OrderVO vo);
	
	 List<OrderVO> getListOrder(String mname);
	
	 void updateOrderResult(int odseq) ;
		

}