package com.chim.biz.service;

import com.chim.biz.dto.MemberVO;

public interface MemberService {

	String confirmMember(String id);

	MemberVO getMember(String id);

}