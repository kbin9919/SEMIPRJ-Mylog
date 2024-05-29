package com.mylog.app.admin.board.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.board.dao.AdminBoardDao;
import com.mylog.app.admin.board.vo.BoardVo;
import com.mylog.app.util.db.SqlSessionTemplate;
import com.mylog.app.util.vo.SearchVo;

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

	public List<BoardVo> selectBoardList(SearchVo searchVo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<BoardVo> boardVoList = dao.selectBoardList(searchVo, ss);
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
