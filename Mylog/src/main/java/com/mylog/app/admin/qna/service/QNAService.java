package com.mylog.app.admin.qna.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.faq.vo.FAQVo;
import com.mylog.app.admin.qna.dao.QNADao;
import com.mylog.app.admin.qna.vo.QNAVo;
import com.mylog.app.util.db.SqlSessionTemplate;
import com.mylog.app.util.vo.SearchVo;

public class QNAService {
	private final QNADao dao;

	public QNAService() {
		this.dao = new QNADao();
	}
		
	public int qnaDelete(String no) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.qnaDelete(ss, no);
		if (result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		return result;
	}

	public List<QNAVo> qnaList() throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<QNAVo> qnaListVo = dao.qnaList(ss);
		ss.close();
		return qnaListVo;
	}

	public QNAVo qnaDetail(String no) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		QNAVo qnaVo = dao.qnaDetail(ss, no);
		ss.close();
		return qnaVo;
	}

	public List<QNAVo> selectQnaList(SearchVo searchVo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<QNAVo> qnaListVo = dao.selectQnaList(ss, searchVo);
		ss.close();
		return qnaListVo;
	}

	public int qnaWrite(QNAVo qnaVo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.qnaWrite(ss, qnaVo);
		if (result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		return result;
	}

}
