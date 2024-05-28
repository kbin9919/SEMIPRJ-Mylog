package com.mylog.app.admin.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.member.vo.AdminVo;
import com.mylog.app.admin.member.vo.MemberSearchVo;
import com.mylog.app.admin.member.vo.MemberVo;
import com.mylog.app.admin.member.vo.WarningVo;

public class AdminMemberDao {
	// 관리자 로그인
	public AdminVo adminLogin(SqlSession ss, AdminVo vo) throws Exception {
		return ss.selectOne("AdminMemberMapper.adminLogin", vo);
	}
	// 관리자 - 계정 전체 조회
	public List<MemberVo> memberList(SqlSession ss) {
		return ss.selectList("AdminMemberMapper.adminMemberList");
	}
	// 관리자 - 계정 검색
	public List<MemberVo> selectMemberList(SqlSession ss, MemberSearchVo memberSearchVo) {
		return ss.selectList("AdminMemberMapper.adminSelectMemberList", memberSearchVo);
	}
	// 관리자 - 계정 상세 조회
	public MemberVo selectMemberDetail(SqlSession ss, String no) {
		return ss.selectOne("AdminMemberMapper.adminSelectMemberDetail", no);
	}
	// 관리자 - 계정 경고하기
	public int warningMember(SqlSession ss, WarningVo warningVo) {
		return ss.insert("AdminMemberMapper.warningMember", warningVo);
	}
	public int deleteMember(SqlSession ss, String memberNo) {
		return ss.update("AdminMemberMapper.deleteMember", memberNo);
	}

	

}
