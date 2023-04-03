package com.chim.biz.service;

import com.chim.biz.dto.AdminVO;

public interface AdminService {

	int adminCheck(AdminVO vo);

	AdminVO getAdmin(String id);

}