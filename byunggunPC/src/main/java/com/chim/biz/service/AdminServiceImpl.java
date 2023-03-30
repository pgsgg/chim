package com.chim.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chim.biz.dao.AdminDAO;
import com.chim.biz.dto.AdminVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDao;
	
	
	@Override
	public String adminCheck(String id) {
		
		return adminDao.adminCheck(id);
	}

	@Override
	public List<AdminVO> getAdmin(AdminVO vo) {
		
		return adminDao.getAdmin(vo);
	}

}
