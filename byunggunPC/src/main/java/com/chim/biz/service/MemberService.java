package com.chim.biz.service;

import java.util.List;

import com.chim.biz.dto.MemberVO;

public interface MemberService {

	String confirmMember(String id);

	MemberVO getMember(String id);

	void insertMember(MemberVO vo);

	String getIdByNamePhone(MemberVO vo);

	void chagePwd(MemberVO vo);
	
	List<MemberVO> getListMember(String name);
}