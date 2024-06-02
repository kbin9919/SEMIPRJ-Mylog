package com.mylog.app.page.qna.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.faq.vo.FAQVo;
import com.mylog.app.admin.notice.vo.NoticeVo;
import com.mylog.app.admin.qna.vo.QNAVo;
import com.mylog.app.page.qna.dao.QnaDao;
import com.mylog.app.util.db.SqlSessionTemplate;
import com.mylog.app.util.vo.PageVo;
import com.mylog.app.util.vo.SearchVo;

public class QnaService {
	private QnaDao dao;
	public QnaService() {
		this.dao = new QnaDao();
	}
	public List<QNAVo> qnaList(PageVo pageVo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<QNAVo> qnaVoList = dao.qnaList(ss, pageVo);
		ss.close();
		return qnaVoList;
	}
	

	public int getTotPage() throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.getTotPage(ss);
		ss.close();
		return result;
	}
	public QNAVo selectQna(String no) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		QNAVo qnaVo = dao.selectQna(ss, no);
		ss.close();
		return qnaVo;
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
	public List<QNAVo> searchQnaList(SearchVo searchVo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<QNAVo> qnaVoList = dao.searchQnaList(ss, searchVo);
		System.out.println(searchVo);
		ss.close();
		return qnaVoList;
	}
	public int getSearchTotPage(SearchVo searchVo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.getSearchTotPage(ss, searchVo);
		ss.close();
		return result;
	}
}
