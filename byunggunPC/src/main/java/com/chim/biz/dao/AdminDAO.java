package com.chim.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.chim.biz.dto.AdminVO;


public class AdminDAO {
	
	private SqlSessionTemplate mybatis;
	
	
	public String adminCheck(String id) {
		
		return mybatis.selectOne("AdminMapper.adminCheck",id);
	}
	
	public List<AdminVO> getAdmin(AdminVO vo){
		
		return mybatis.selectList("AdminMapper.getAdmin",vo);
	} 
	
	
}
