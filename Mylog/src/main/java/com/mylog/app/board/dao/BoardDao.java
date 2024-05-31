package com.mylog.app.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.board.vo.BoardVo;
import com.mylog.app.recommend.vo.RecommendVo;
import com.mylog.app.util.vo.SearchVo;
import com.mylog.app.visitor.vo.VisitorVo;

public class BoardDao {
	
	// 게시글 작성
	public int writeBoard(SqlSession ss, BoardVo vo) {
		return ss.insert("BoardMapper.writeBoard", vo);
	}
	
	// 게시글 삭제
	public int deleteBoard (SqlSession ss, String no) {
		return ss.update("BoardMapper.deleteBoard", no);
	}
	
	// 게시글 수정
	public int editBoard(SqlSession ss, BoardVo vo) {
		return ss.update("BoardMapper.editBoard", vo);
	}
	
	// 게시글 최신 조회
	public List<BoardVo> recentBoardCheck(SqlSession ss) {
		return ss.selectList("BoardMapper.recentBoardCheck");
	}
	
	// 트렌딩 게시글 조회
	public List<BoardVo> trendingBoardCheck(SqlSession ss) {
		return ss.selectList("BoardMapper.trendingBoardCheck");
	}
	
	// 팔로우한 사람들 게시글 조회
	public List<BoardVo> feedBoardCheck(SqlSession ss, String followerNo) {
		return ss.selectList("BoardMapper.feedBoardCheck", followerNo);
		
	}
	
	// 게시물 상세조회
	public BoardVo detailBoardCheck(SqlSession ss, String no) {
		return ss.selectOne("BoardMapper.detailBoardCheck", no);
	}
	
	// 전체 게시물 조회
	public List<BoardVo> allBoardCheck(SqlSession ss) {
		return ss.selectList("BoardMapper.allBoardCheck");
	}
	
	// 게시물 검색
	public List<BoardVo> searchBoard(SqlSession ss, SearchVo vo){
		return ss.selectList("BoardMapper.searchBoard", vo);
	}
	
	// ----------- 방문자 추가(조회수 증가) -----------
	
	// 방문자 추가
	public int insertVisitor(SqlSession ss, VisitorVo vo) {
		return ss.insert("BoardMapper.insertVisitor", vo);
	}
	
	// 특정 보드에 방문자 번호 조회
	public List<VisitorVo> getBoardListLoginMember(SqlSession ss, String boardNo) {
		return ss.selectList("BoardMapper.getBoardListLoginMember");
	}
	
	// ----------- 좋아요 수 증감 -----------
	
	// 추천인 추가
	public int insertRecommend(SqlSession ss, RecommendVo vo) {
		return ss.insert("BoardMapper.insertRecommend", vo);
	}
	
	// 특정 보드에 추천인 번호 조회
	public RecommendVo getRecommendLoginMember(SqlSession ss, String boardNo) {
		return ss.selectOne("BoardMapper.getRecommendLoginMember", boardNo);
	}
	
	// 추천인 삭제
	public int deleteRecommend(SqlSession ss) {
		return ss.delete("BoardMapper.deleteRecommend");
	}

}



