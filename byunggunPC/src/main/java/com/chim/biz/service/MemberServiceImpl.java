package com.chim.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chim.biz.dao.MemberDAO;
import com.chim.biz.dto.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public String confirmMember(String id) {
		// TODO Auto-generated method stub
		return memberDAO.confirmMember(id);
	}

	@Override
	public MemberVO getMember(String id) {
		// TODO Auto-generated method stub
		return memberDAO.getMember(id);
	}

	@Override
	public void insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDAO.insertMember(vo);
	}

	@Override
	public String getIdByNamePhone(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberDAO.selectIdByNamePhone(vo);
	}

	@Override
	public void chagePwd(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDAO.chagePwd(vo);
	}

	@Override
	public List<MemberVO> getListMember(String name) {
		// TODO Auto-generated method stub
		return memberDAO.getListMember(name);
	}

	@Override
	public void updateOrderSheet(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDAO.updateOrderSheet(vo);
	}

	

}
