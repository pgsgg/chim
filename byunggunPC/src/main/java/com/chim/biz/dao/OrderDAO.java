package com.chim.biz.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chim.biz.dto.MemberVO;
import com.chim.biz.dto.OrderVO;

import utils.Criteria;

@Repository
public class OrderDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public int selectMaxOseq() {

		return mybatis.selectOne("OrderMapper.selectMaxOseq");
	}

	public void insertOrder(OrderVO vo) {

		mybatis.insert("OrderMapper.insertOrder", vo);
	}

	public void insertOrderDetail(OrderVO vo) {

		mybatis.insert("OrderMapper.insertOrderDetail", vo);
	}

	public List<OrderVO> listOrderById(OrderVO vo) {

		return mybatis.selectList("OrderMapper.listOrderById", vo);
	}

	public List<Integer> selectSeqOrdering(OrderVO vo,Criteria criteria) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", vo.getId());
		map.put("result", vo.getResult());
		map.put("criteria", criteria);
		
		return mybatis.selectList("OrderMapper.selectSeqOrdering", map);
	}

	public void deleteOrder(int oseq) {

		mybatis.delete("OrderMapper.deleteOrder", oseq);
	}
	
	public int countOrderListById(OrderVO vo) {
		
		return mybatis.selectOne("OrderMapper.countOrderListById", vo);
	}
	public List<OrderVO> listOrder(String mname){
		
		return mybatis.selectList("OrderMapper.listOrder",mname);
	}
	
	public void updateOrderResult(int odseq) {
		
		mybatis.update("OrderMapper.updateOrderResult",odseq);
	}
	
	public void updateOrderSheet(MemberVO vo) {
		mybatis.update("OrderMapper.updateOrderSheet", vo);
	}
}
