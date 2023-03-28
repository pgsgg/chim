package com.chim.biz.service;

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

}
