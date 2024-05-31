package com.mylog.app.page.notice.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mylog.app.admin.notice.vo.NoticeVo;
import com.mylog.app.page.notice.dao.NoticeDao;
import com.mylog.app.util.db.SqlSessionTemplate;
import com.mylog.app.util.vo.PageVo;
import com.mylog.app.util.vo.SearchVo;

public class NoticeService{
	private final NoticeDao dao;

	public NoticeService() {
		this.dao = new NoticeDao();
	}
	
	public List<NoticeVo> noticeList(PageVo pageVo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<NoticeVo> noticeVoList = dao.noticeList(ss, pageVo);
		ss.close();
		return noticeVoList;
	}

	public int getTotPage() throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		int result = dao.getTotPage(ss);
		ss.close();
		return result;
	}

	public NoticeVo selectNotice(String no) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		NoticeVo noticeVo = dao.selectNotice(ss, no);
		ss.close();
		return noticeVo;
	}

	public List<NoticeVo> selectNoticeList(SearchVo searchVo) throws Exception {
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		List<NoticeVo> noticeVoList = dao.searchNoticeList(ss, searchVo);
		ss.close();
		return noticeVoList;
	}


	

}
