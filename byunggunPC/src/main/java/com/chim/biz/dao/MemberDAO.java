package com.chim.biz.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chim.biz.dto.MemberVO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate mybatis;

	public String confirmMember(String id) {

		return mybatis.selectOne("MemberMapper.confirmMember", id);
	}
	
	public MemberVO getMember(String id) {
		
		return mybatis.selectOne("MemberMapper.getMember", id);
	}
}
