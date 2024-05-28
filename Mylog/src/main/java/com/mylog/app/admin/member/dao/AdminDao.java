package com.mylog.app.admin.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.member.vo.AdminVo;
import com.mylog.app.admin.member.vo.MemberSearchVo;
import com.mylog.app.admin.member.vo.MemberVo;

public class AdminDao {
	// 관리자 로그인
	public AdminVo adminLogin(SqlSession ss, AdminVo vo) throws Exception {
		return ss.selectOne("AdminMapper.adminLogin", vo);
	}
	// 관리자 - 계정 전체 조회
	public List<MemberVo> memberList(SqlSession ss) {
		return ss.selectList("AdminMapper.memberList");
	}
	// 관리자 - 계정 검색
	public List<MemberVo> selectMemberList(SqlSession ss, MemberSearchVo memberSearchVo) {
		return ss.selectList("AdminMapper.selectMemberList", memberSearchVo);
	}
	// 관리자 - 계정 상세 조회
	public MemberVo selectMemberDetail(SqlSession ss, String no) {
		return ss.selectOne("AdminMapper.selectMemberDetail", no);
	}

	

}
