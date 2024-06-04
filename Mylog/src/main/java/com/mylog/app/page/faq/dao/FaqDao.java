package com.mylog.app.page.faq.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.faq.vo.FAQVo;
import com.mylog.app.util.vo.PageVo;
import com.mylog.app.util.vo.SearchVo;

public class FaqDao {
	public List<FAQVo> faqList(SqlSession ss, PageVo pageVo) {
		return ss.selectList("FaqMapper.faqList", pageVo);
	}

	public int getTotPage(SqlSession ss) {
		return ss.selectOne("FaqMapper.getTotPage");
	}

	public FAQVo selectFaq(SqlSession ss, String no) {
		return ss.selectOne("FaqMapper.selectFaq", no);
	}

	public List<FAQVo> searchFaqList(SqlSession ss, SearchVo searchVo) {
		return ss.selectList("FaqMapper.searchFaqList", searchVo);
	}

	public int getSearchTotPage(SqlSession ss, SearchVo searchVo) {
		return ss.selectOne("FaqMapper.getSearchTotPage");
	}
}
