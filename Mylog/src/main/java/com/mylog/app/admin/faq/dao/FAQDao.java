package com.mylog.app.admin.faq.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.faq.vo.FAQVo;
import com.mylog.app.util.vo.SearchVo;

public class FAQDao {

	public int faqWrite(SqlSession ss, FAQVo faqVo) {
		return ss.insert("AdminFAQMapper.faqWrite", faqVo);
	}

	public FAQVo faqDetail(SqlSession ss, String no) {
		return ss.selectOne("AdminFAQMapper.faqDetail", no);
	}

	public List<FAQVo> faqList(SqlSession ss) {
		return ss.selectList("AdminFAQMapper.faqList");
	}

	public List<FAQVo> selectFaqList(SqlSession ss, SearchVo searchVo) {
		return ss.selectList("AdminFAQMapper.selectFaqList", searchVo);
	}

	public int faqDelete(SqlSession ss, String no) {
		return ss.delete("AdminFAQMapper.faqDelete", no);
	}

	public int editFaq(SqlSession ss, FAQVo faqVo) {
		return ss.update("AdminFAQMapper.editFAQ", faqVo);
	}

}
