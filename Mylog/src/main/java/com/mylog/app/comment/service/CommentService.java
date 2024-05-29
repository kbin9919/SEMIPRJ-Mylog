package com.mylog.app.comment.service;

import static com.mylog.app.util.db.SqlSessionTemplate.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.comment.dao.CommentDao;
import com.mylog.app.comment.vo.CommentVo;

public class CommentService {
	
private final CommentDao dao;
	
	public CommentService() {
		dao = new CommentDao();
	}
	
	// 댓글 작성
	public int writeComment(CommentVo vo) throws Exception {
		SqlSession ss = getSqlSession();
		
		int result = dao.writeComment(ss, vo);
		
		if(result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		
		return result;
	}

}
