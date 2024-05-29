package com.mylog.app.board.service;

import static com.mylog.app.util.db.SqlSessionTemplate.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.board.dao.BoardDao;
import com.mylog.app.board.vo.BoardVo;

public class BoardService {
	
private final BoardDao dao;
	
	public BoardService() {
		dao = new BoardDao();
	}
	
	// 게시글 작성
	public int wrtieBoard(BoardVo vo) throws Exception {
		
		//Dao 호출
		SqlSession ss = getSqlSession();
		int result = dao.writeBoard(ss, vo);
		
		if(result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		
		return result;
		
	}
	
	// 게시글 삭제
	public int deleteBoard(String no) throws Exception {
		
		//Dao 호출
		SqlSession ss = getSqlSession();
		
		int result = dao.deleteBoard(ss, no);
		
		if(result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		
		return result;
	}
	
	// 게시글 수정
	public int editBoard(BoardVo vo) throws Exception {
		SqlSession ss = getSqlSession();
		
		int result = dao.editBoard(ss, vo);
		
		if(result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		
		return result;
	
	}

	// 최신 게시글 조회
	public List<BoardVo> recentBoardCheck() throws Exception {
		
		SqlSession ss = getSqlSession();
		List<BoardVo> voList = dao.recentBoardCheck(ss);
		ss.close();
		
		return voList;
	}

	

}
