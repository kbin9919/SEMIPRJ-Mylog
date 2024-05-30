package com.mylog.app.board.service;

import static com.mylog.app.util.db.SqlSessionTemplate.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.board.dao.BoardDao;
import com.mylog.app.board.vo.BoardVo;
import com.mylog.app.visitor.vo.VisitorVo;

public class BoardService {

	private final BoardDao dao;

	public BoardService() {
		dao = new BoardDao();
	}

	// 게시글 작성
	public int wrtieBoard(BoardVo vo) throws Exception {

		// Dao 호출
		SqlSession ss = getSqlSession();
		int result = dao.writeBoard(ss, vo);

		if (result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();

		return result;

	}

	// 게시글 삭제
	public int deleteBoard(String no) throws Exception {

		// Dao 호출
		SqlSession ss = getSqlSession();

		int result = dao.deleteBoard(ss, no);

		if (result == 1) {
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

		if (result == 1) {
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

	// 트렌딩 게시글 조회
	public List<BoardVo> trendingBoardCheck() throws Exception {
		SqlSession ss = getSqlSession();
		List<BoardVo> voList = dao.trendingBoardCheck(ss);
		ss.close();

		return voList;
	}

	// 피드 게시글 조회
	public List<BoardVo> feedBoardCheck(String followerNo) throws Exception {
		SqlSession ss = getSqlSession();
		List<BoardVo> voList = dao.feedBoardCheck(ss, followerNo);
		ss.close();

		return voList;
	}

	// 게시물 상세조회
	public BoardVo detailBoardCheck(String no, VisitorVo vo, boolean isSelf) throws Exception {

		BoardVo bvo = null;
		SqlSession ss = null;
		try {
			ss = getSqlSession();

			int result = 1;

			if (!isSelf) {
				result = dao.insertVisitor(ss, vo);
			}

			bvo = dao.detailBoardCheck(ss, no);

			if (result == 1 && bvo != null && vo != null) {
				ss.commit();
			} else {
				ss.rollback();
				throw new Exception("게시글 조회수 증가 실패");
			}

		} finally {
			ss.close();
		}

		return bvo;
	}

}
