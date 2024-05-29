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

	public int noticeWrite(FAQVo vo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.noticeWrite(ss, vo);
		if (result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		return result;
	}

	public FAQVo noticeDetail(String no) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		FAQVo noticeVo = dao.noticeDetail(ss, no);
		ss.close();
		return noticeVo;
	}

	public List<FAQVo> noticeList() throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<FAQVo> noticeListVo = dao.noticeList(ss);
		ss.close();
		return noticeListVo;
	}

	public List<FAQVo> selectNoticeList(SearchVo searchVo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<FAQVo> noticeListVo = dao.selectNoticeList(ss, searchVo);
		ss.close();
		return noticeListVo;
	}

	public int noticeDelete(String no) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.noticeDelete(ss, no);
		if (result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		return result;
	}

	public int editNotice(FAQVo noticeVo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.editNotice(ss, noticeVo);
		if (result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		ss.close();
		return result;
	}
}
