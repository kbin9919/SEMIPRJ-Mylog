package com.mylog.app.board.service;

import static com.mylog.app.util.db.SqlSessionTemplate.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.board.dao.BoardDao;
import com.mylog.app.util.vo.AttachmentVo;
import com.mylog.app.board.vo.BoardVo;
import com.mylog.app.board.vo.CategoryVo;
import com.mylog.app.recommend.vo.RecommendVo;
import com.mylog.app.util.vo.SearchVo;
import com.mylog.app.visitor.vo.VisitorVo;

public class BoardService {

	private final BoardDao dao;

	public BoardService() {
		dao = new BoardDao();
	}

	// 이미지
	public List<AttachmentVo> getAttachment(String no) throws Exception {
		SqlSession ss = getSqlSession();
		List<AttachmentVo> attVoList = null;

		try {
			attVoList = dao.getAttachment(ss, no);
			ss.commit();
		} catch (Exception e) {
			ss.rollback();
			throw e;
		} finally {
			ss.close();
		}

		return attVoList;
	}

	// 게시글 작성
	public int wrtieBoard(BoardVo vo, List<AttachmentVo> attVoList) throws Exception {

		// Dao 호출
		SqlSession ss = getSqlSession();
		int result = dao.writeBoard(ss, vo);

		int attResult = 1;
		if (attVoList.size() > 0) {
			attResult = dao.insertBoardAttachment(ss, attVoList);
		}

		if (result * attResult >= 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();

		return result * attResult;

	}

	// 게시글 삭제
	public int deleteBoard(BoardVo vo) throws Exception {

		// Dao 호출
		SqlSession ss = getSqlSession();

		int result = dao.deleteBoard(ss, vo);

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

	// 카테고리 목록조회
	public List<CategoryVo> getCategoryVoList() throws Exception {
		SqlSession ss = getSqlSession();
		List<CategoryVo> categoryVoList = dao.getCategoryVoList(ss);
		ss.close();
		return categoryVoList;
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
	public BoardVo detailBoardCheck(String no, VisitorVo visitor) throws Exception {
		SqlSession ss = getSqlSession();
		BoardVo vo = null;
		try {
			vo = dao.detailBoardCheck(ss, no);

			// 조회수 증가
			if (visitor != null) {
				int result = insertVisitor(ss, visitor);
				if (result > 0) {
					ss.commit();
				} else {
					ss.rollback();
				}
			}
		} catch (Exception e) {
			ss.rollback();
		} finally {
			ss.close();
		}
		return vo;
	}

	// 게시물 전체 조회
	public List<BoardVo> allBoardCheck() throws Exception {
		SqlSession ss = getSqlSession();
		List<BoardVo> voList = dao.allBoardCheck(ss);
		ss.close();
		return voList;
	}

	// 게시글 검색
	public List<BoardVo> searchBoard(SearchVo vo) throws Exception {
		SqlSession ss = getSqlSession();
		List<BoardVo> voList = dao.searchBoard(ss, vo);
		ss.close();
		return voList;
	}

	// 게시글 조회수 증가
	public int insertVisitor(SqlSession ss, VisitorVo vo) throws Exception {
		List<VisitorVo> vvo = dao.getBoardListLoginMember(ss, vo.getBoardNo());
		int result = 0;

		boolean visitorExists = false;

		for (VisitorVo V : vvo) {
			if (V.getVisitorNum().equals(vo.getVisitorNum())) {
				visitorExists = true;
				break;
			}

		}

		if (!visitorExists) {
			result = dao.insertVisitor(ss, vo);
		}

		if (result > 0) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();

		return result;
	}

	// 좋아요수 증가 감소 -- 미완 --
	public void recommendIDcrease(RecommendVo vo) throws Exception {
		SqlSession ss = getSqlSession();
		RecommendVo rvo = dao.getRecommendLoginMember(ss, vo.getBoardNo());
	}

}
