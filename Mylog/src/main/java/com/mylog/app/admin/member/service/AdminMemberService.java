package com.mylog.app.admin.member.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.member.dao.AdminMemberDao;
import com.mylog.app.admin.member.vo.AdminVo;
import com.mylog.app.admin.member.vo.MemberSearchVo;
import com.mylog.app.admin.member.vo.MemberVo;
import com.mylog.app.util.db.SqlSessionTemplate;

public class AdminMemberService {
	// dao 객체 생성
	private final AdminMemberDao dao;

	public AdminMemberService() {
		this.dao = new AdminMemberDao();
	}

	// 관리자 로그인
	public AdminVo adminLogin(AdminVo vo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		AdminVo loginAdminVo = dao.adminLogin(ss, vo);
		// biz
		if (!loginAdminVo.getAdminYn().equals("Y")) {
			throw new Exception("관리자가 아닙니다.");
		}

		ss.close();
		return loginAdminVo;
	}
	// 관리자 - 계정 전체 조회
	public List<MemberVo> memberList() throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<MemberVo> memberVoList = dao.memberList(ss);
		ss.close();
		return memberVoList;
	}
	
	// 관리자 - 계정 검색
	public List<MemberVo> selectMemberList(MemberSearchVo memberSearchVo) throws Exception {
		// dao
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<MemberVo> memberVoList = dao.selectMemberList(ss, memberSearchVo);
		ss.close();
		return memberVoList;
	}
	
	// 관리자 - 계정 상세 조회
	public MemberVo selectMemberDetail(String no) throws Exception {
		// dao
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		MemberVo memberVo = dao.selectMemberDetail(ss, no);
		ss.close();
		return memberVo;
	}

	

}
