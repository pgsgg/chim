package com.chim.biz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chim.biz.dao.AdminDAO;
import com.chim.biz.dto.AdminVO;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDao;
	
	
	@Override
	public int adminCheck(AdminVO vo) {
		String pwd = adminDao.adminCheck(vo.getId());
		if(pwd==null)
			return -1; //아이디없음
		else if (pwd.equals(vo.getPwd()))
			return 1; //정상
		else return 0 ; //틀림
	}

	@Override
	public AdminVO getAdmin(String id) {
		
		return adminDao.getAdmin(id);
	}

}
