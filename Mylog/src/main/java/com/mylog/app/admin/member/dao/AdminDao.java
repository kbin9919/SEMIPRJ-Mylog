package com.mylog.app.admin.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.member.vo.AdminVo;

public class AdminDao {

	public AdminVo getAdminVo(SqlSession ss, AdminVo vo) throws Exception {
		return ss.selectOne("AdminMapper.adminLogin", vo);
	}

}
