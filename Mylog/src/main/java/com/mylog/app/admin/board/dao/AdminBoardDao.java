package com.mylog.app.admin.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.board.vo.BoardVo;
import com.mylog.app.util.vo.SearchVo;

public class AdminBoardDao {

	public List<BoardVo> boardList(SqlSession ss) {
		return ss.selectList("AdminBoardMapper.adminBoardList");
	}

	public List<BoardVo> selectBoardList(SearchVo searchVo, SqlSession ss) {
		return ss.selectList("AdminBoardMapper.adminSelectBoardList");
	}

	public BoardVo selectBoardDetail(SqlSession ss, String no) {
		return ss.selectOne("AdminBoardMapper.adminSelectBoardDetail", no);
	}

}
