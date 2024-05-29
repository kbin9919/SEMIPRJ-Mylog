package com.mylog.app.admin.faq.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.faq.vo.FAQVo;
import com.mylog.app.util.vo.SearchVo;

public class FAQDao {

	public int noticeWrite(SqlSession ss, FAQVo vo) {
		return ss.insert("AdminFAQMapper.noticeWrite", vo);
	}

	public FAQVo noticeDetail(SqlSession ss, String no) {
		return ss.selectOne("AdminFAQMapper.noticeDetail", no);
	}

	public List<FAQVo> noticeList(SqlSession ss) {
		return ss.selectList("AdminFAQMapper.noticeList");
	}

	public List<FAQVo> selectNoticeList(SqlSession ss, SearchVo searchVo) {
		return ss.selectList("AdminFAQMapper.selectNoticeList", searchVo);
	}

	public int faqDelete(SqlSession ss, String no) {
		return ss.delete("AdminFAQMapper.faqDelete", no);
	}

	public int editNotice(SqlSession ss, FAQVo noticeVo) {
		return ss.update("AdminFAQMapper.editNotice", noticeVo);
	}

}
