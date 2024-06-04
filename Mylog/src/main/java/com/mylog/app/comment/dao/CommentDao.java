package com.mylog.app.comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.comment.vo.CommentVo;

public class CommentDao {
	
	// 댓글 작성
	public int writeComment(SqlSession ss, CommentVo vo) {
		return ss.insert("CommentMapper.writeComment", vo);
	}
	
	// 댓글 수정
	public int editComment(SqlSession ss, CommentVo vo) {
		return ss.update("CommentMapper.editComment", vo);
	}
	
	// 댓글 삭제
	public int deleteComment(SqlSession ss, CommentVo vo) {
		return ss.update("CommentMapper.deleteComment", vo);
	}
	
	// 댓글 전체 조회
	public List<CommentVo> commentListCheck(SqlSession ss, String boardNo) {
		return ss.selectList("CommentMapper.commentListCheck", boardNo);
	}
}
