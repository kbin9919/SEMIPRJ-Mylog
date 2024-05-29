package com.mylog.app.comment.dao;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.comment.vo.CommentVo;

public class CommentDao {
	
	// 댓글 작성
	public int writeComment(SqlSession ss, CommentVo vo) {
		return ss.insert("CommentMapper.writeComment", vo);
	}

}
