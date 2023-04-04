package com.chim.biz.dao;

import java.util.List;

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

	public void insertMember(MemberVO vo) {

		mybatis.insert("MemberMapper.insertMember", vo);
	}

	public String selectIdByNamePhone(MemberVO vo) {

		return mybatis.selectOne("MemberMapper.selectIdByNamePhone", vo);
	}

	public void chagePwd(MemberVO vo) {

		mybatis.update("MemberMapper.chagePwd", vo);
	}
	
	public List<MemberVO> getListMember(String name) {
		return mybatis.selectList("MemberMapper.listMember",name);
	}

}
