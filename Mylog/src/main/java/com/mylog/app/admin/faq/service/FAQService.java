package com.mylog.app.admin.faq.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.faq.dao.FAQDao;
import com.mylog.app.admin.faq.vo.FAQVo;
import com.mylog.app.util.db.SqlSessionTemplate;
import com.mylog.app.util.vo.SearchVo;

public class FAQService {
	private final FAQDao dao;

	public FAQService() {
		this.dao = new FAQDao();
	}

	public int faqWrite(FAQVo faqVo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.faqWrite(ss, faqVo);
		if (result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		return result;
	}

	public FAQVo faqDetail(String no) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		FAQVo faqVo = dao.faqDetail(ss, no);
		ss.close();
		return faqVo;
	}

	public List<FAQVo> faqList() throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<FAQVo> faqListVo = dao.faqList(ss);
		ss.close();
		return faqListVo;
	}

	public List<FAQVo> selectFaqList(SearchVo searchVo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<FAQVo> faqListVo = dao.selectFaqList(ss, searchVo);
		ss.close();
		return faqListVo;
	}

	public int faqDelete(String no) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.faqDelete(ss, no);
		if (result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		return result;
	}

	public int editFaq(FAQVo faqVo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.editFaq(ss, faqVo);
		if (result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		return result;
	}
}
