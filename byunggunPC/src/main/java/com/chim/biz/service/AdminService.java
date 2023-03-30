package com.chim.biz.service;

import java.util.List;

import com.chim.biz.dto.AdminVO;

public interface AdminService {

	String adminCheck(String id);

	List<AdminVO> getAdmin(AdminVO vo);

}