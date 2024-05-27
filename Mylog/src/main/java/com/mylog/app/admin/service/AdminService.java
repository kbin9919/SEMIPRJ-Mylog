package com.mylog.app.admin.service;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.dao.AdminDao;
import com.mylog.app.admin.vo.AdminVo;
import com.mylog.app.util.db.SqlSessionTemplate;

public class AdminService {

	private final AdminDao dao;

	public AdminService() {
		this.dao = new AdminDao();
	}

	public AdminVo login(AdminVo vo) throws Exception {
		// dao
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		AdminVo loginAdminVo = dao.getAdminVo(ss, vo);
		
		// biz
		if (!vo.getAdminYn().equals("Y")) {
			throw new Exception("관리자가 아닙니다.");
		}
		
		ss.close();
		return loginAdminVo;
	}

}
