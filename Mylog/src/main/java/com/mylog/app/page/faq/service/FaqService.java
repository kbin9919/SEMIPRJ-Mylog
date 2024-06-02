package com.mylog.app.page.faq.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.faq.vo.FAQVo;
import com.mylog.app.admin.notice.vo.NoticeVo;
import com.mylog.app.page.faq.dao.FaqDao;
import com.mylog.app.util.db.SqlSessionTemplate;
import com.mylog.app.util.vo.PageVo;
import com.mylog.app.util.vo.SearchVo;

public class FaqService {
	private FaqDao dao;
	public FaqService() {
		this.dao = new FaqDao();
	}
	public List<FAQVo> faqList(PageVo pageVo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<FAQVo> faqVoList = dao.faqList(ss, pageVo);
		ss.close();
		return faqVoList;
	}

	public int getTotPage() throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.getTotPage(ss);
		ss.close();
		return result;
	}
	public FAQVo selectFaq(String no) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		FAQVo faqVo = dao.selectFaq(ss, no);
		ss.close();
		return faqVo;
	}
	public List<FAQVo> searchFaqList(SearchVo searchVo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<FAQVo> faqVoList = dao.searchFaqList(ss, searchVo);
		ss.close();
		return faqVoList;
	}
	public int getSearchTotPage(SearchVo searchVo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.getSearchTotPage(ss ,searchVo);
		ss.close();
		return result;
	}
}
