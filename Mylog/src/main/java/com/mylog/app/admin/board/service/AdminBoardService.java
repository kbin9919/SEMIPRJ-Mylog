package com.mylog.app.admin.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.board.dao.AdminBoardDao;
import com.mylog.app.admin.board.vo.BoardSearchVo;
import com.mylog.app.admin.board.vo.BoardVo;
import com.mylog.app.admin.member.vo.MemberVo;
import com.mylog.app.util.db.SqlSessionTemplate;

public class AdminBoardService {

	private final AdminBoardDao dao;

	public AdminBoardService() {
		this.dao = new AdminBoardDao();
	}

	public List<BoardVo> boardList() throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<BoardVo> boardVoList = dao.boardList(ss);
		ss.close();
		return boardVoList;
	}

	public List<BoardVo> selectBoardList(BoardSearchVo boardSearchVo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<BoardVo> boardVoList = dao.selectBoardList(boardSearchVo, ss);
		ss.close();
		return boardVoList;
	}

	public BoardVo selectBoardDetail(String no) throws Exception {
		// dao
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		BoardVo boardVo = dao.selectBoardDetail(ss, no);
		ss.close();
		return boardVo;
	}

}
